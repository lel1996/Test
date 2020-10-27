package com.wxq.poi.utils;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
//import cn.crcc.ccit.chassis.utils.clazz.BeanProxy;
//import cn.crcc.ccit.chassis.utils.clazz.BeanProxyBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wangxiaoqi
 * @Description TODO
 * @date 2020-06-08 11:43
 */
@Slf4j
public class PoiExcelUtils {
    /**
     * 日期时间格式
     **/
    public static DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期格式
     **/
    public static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 时间格式
     */
    public static DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH-mm-ss");

    /**
     * 日期类型列表
     */
    public static short[] DATE_TYPE_LIST = {14, 31, 57, 58, 179, 184, 185, 186, 187, 188};

    /**
     * 时间类型列表
     */
    public static short[] TIME_TYPE_LIST = {20, 32, 190, 191, 192};

    /**
     * 私有构造方法
     */
    public PoiExcelUtils() {
    }

    /**
     * @param filePath: 文件路径
     * @Description: 根据路径，获取WorkBook对象
     * @author wangxiaoqi
     * @date 2020-06-08 12:07:50
     * @return: Workbook excel工作簿对象
     **/
    public static Workbook getExcelWorkbook(String filePath) throws Exception {
        File file = new File(filePath);
        if (file.exists()) {
            return getWorkBookByStream(new FileInputStream(file));
        }
        return null;
    }

    /**
     * @param inputStream: 输入流
     * @Description:根据输入流inputStream获取WorkBook对象
     * @author wangxiaoqi
     * @date 2020-06-08 12:10:24
     * @return: Workbook对象
     **/
    public static Workbook getWorkBookByStream(InputStream inputStream) throws Exception {
        return WorkbookFactory.create(inputStream);
    }

    /**
     * @param workbook:   excel工作对象
     * @param sheetIndex: 表格对象，从0开始
     * @Description:根据Workbook，sheetIndex获取sheet对象
     * @author wangxiaoqi
     * @date 2020-06-08 12:13:52
     * @return: org.apache.poi.ss.usermodel.Sheet 表单对象
     **/
    public static Sheet getSheetByNum(Workbook workbook, int sheetIndex) {
        return workbook.getSheetAt(sheetIndex);
    }

    /**
     * @param workbook: excel工作簿对象
     * @Description:根据workbook对象返回workbook对象中所有sheet的名称数组
     * @author wangxiaoqi
     * @date 2020-06-08 12:17:31
     * @return: java.lang.String[] 名称数组
     **/
    public static String[] getSheetNameByBook(Workbook workbook) {
        String[] names = new String[workbook.getNumberOfSheets()];
        for (int i = 0; i < names.length; i++) {
            names[i] = getSheetByNum(workbook, i).getSheetName();
        }
        return names;
    }

    /**
     * @param workbook: excel工作簿对象
     * @Description:获取workbookshuju的三维数组
     * @author wangxiaoqi
     * @date 2020-06-08 12:21:23
     * @return: java.lang.String[][][]
     **/
    public static String[][][] getWorkbookDatas(Workbook workbook) {
        String[][][] datas = new String[workbook.getNumberOfSheets()][][];
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            datas[i] = getSheetData(getSheetByNum(workbook, i));
        }
        return datas;
    }

    /**
     * @param sheet: 表表对象
     * @Description:获取单个表中的数据(二维数组方式)
     * @author wangxiaoqi
     * @date 2020-06-08 12:23:12
     * @return: java.lang.String[][]单个表中的数据(二维数组方式)
     **/
    public static String[][] getSheetData(Sheet sheet) {
        //需要先合并单元格数据
        restoreMergedRegion(sheet);
        int columnCount = getMaxColumnCount(sheet);
        int rowCount = getRowCount(sheet);
        String[][] datas = new String[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            datas[i] = getRowData(sheet.getRow(i), columnCount);
        }
        return datas;
    }

    /**
     * @param row:         excel行对象
     * @param columnCount: 获取数据的列数
     * @Description:读取一行的数据,返回的是字符串数组
     * @author wangxiaoqi
     * @date 2020-06-08 12:24:41
     * @return: java.lang.String[]行数据数组
     **/
    public static String[] getRowData(Row row, int columnCount) {
        String[] data = new String[columnCount];
        if (row == null) {
            for (int i = 0; i < columnCount; i++) {
                data[i] = "";
            }
        } else {
            for (int i = 0; i < columnCount; i++) {
                data[i] = getCellData(row.getCell(i));
            }
        }
        return data;
    }

    /**
     * @param sheet: sheet 表对象
     * @Description:返回指定sheet页的最大行数,例如:25,则表示下标从0...24
     * @author wangxiaoqi
     * @date 2020-06-08 12:25:45
     * @return: int行数
     **/
    public static int getRowCount(Sheet sheet) {
        return sheet.getLastRowNum() + 1;
    }

    /**
     * @param sheet: sheet 表对象
     * @Description:返回指定sheet页的最大列数,例如:25,则表示下标从0...24
     * @author wangxiaoqi
     * @date 2020-06-08 12:26:15
     * @return: int最大列数
     **/
    public static int getMaxColumnCount(Sheet sheet) {
        int rowCount = getRowCount(sheet);
        int max = 0;
        for (int i = 0; i < rowCount; i++) {
            int c = sheet.getRow(i).getLastCellNum();
            if (c > max) {
                max = c;
            }
        }
        return max;
    }

    /**
     * @param sheet:     excel表对象
     * @param rowIndex:  行索引
     * @param cellIndex: 列索引
     * @Description:获取指定sheet中指定rowNum和cellNum的值
     * @author wangxiaoqi
     * @date 2020-06-08 12:26:45
     * @return: java.lang.String
     **/
    public static String getSheetCellValueByRowIndexAndColIndex(Sheet sheet, int rowIndex, int cellIndex) {
        return getCellData(sheet.getRow(rowIndex).getCell(cellIndex));
    }

    /**
     * @param sheet:    指定的Sheet
     * @param colIndex: 指定的列
     * @Description:获取指定Sheet中指定一列的数据.
     * @author wangxiaoqi
     * @date 2020-06-08 12:28:02
     * @return: java.lang.String[]
     **/
    public static String[] getColumnData(Sheet sheet, int colIndex) {
        int rowCount = getRowCount(sheet);
        String[] data = new String[rowCount];
        for (int i = 0; i < rowCount; i++) {
            data[i] = getSheetCellValueByRowIndexAndColIndex(sheet, i, colIndex);
        }
        return data;
    }

    /**
     * @param sheet: 指定的Sheet
     * @param key:   指定的列
     * @Description:获取指定Sheet中指定一列的数据.
     * @author wangxiaoqi
     * @date 2020-06-08 12:28:35
     * @return: java.lang.String[]
     **/
    public static String[] getColumnDataByHeadKey(Sheet sheet, String key) throws Exception {
        int colIndex = ArrayUtils.indexOf(getRowData(sheet.getRow(0), getMaxColumnCount(sheet)), key);
        if (colIndex < 0) {
            return null;
        }
        return getColumnData(sheet, colIndex);
    }

    /**
     * @param cell:
     * @Description:获取单元中值(字符串类型)
     * @author wangxiaoqi
     * @date 2020-06-08 12:29:30
     * @return: java.lang.String
     **/
    public static String getCellData(Cell cell) {
        if (cell == null) {
            return StringUtils.EMPTY;
        }
        try {
            switch (cell.getCellType()) {
                // 空白
                case BLANK:
                    return StringUtils.EMPTY;
                // 数值型 0----日期类型也是数值型的一种
                case NUMERIC:
                    return convertNumric(cell);
                // 字符串型 1
                case STRING:
                    return StringUtils.trimToEmpty(cell.getStringCellValue());
                // 公式型 2
                case FORMULA:
                    cell.setCellType(CellType.STRING);
                    return StringUtils.trimToEmpty(cell.getStringCellValue());
                // 布尔型 4
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                // 错误 5
                case ERROR:
                    return "!#REF!";
                default:
                    return StringUtils.EMPTY;
            }
        } catch (Exception e) {
            log.error("读取Excel单元格数据出错：", e);
            return StringUtils.EMPTY;
        }
    }

    /**
     * @param cell: 指定的单元格
     * @Description:将数字类型数字转换为字符串数据
     * @author wangxiaoqi
     * @date 2020-06-08 12:58:25
     * @return: java.lang.String字符串数据
     **/
    private static String convertNumric(Cell cell) {
        if (DateUtil.isCellDateFormatted(cell)) {
            short format = cell.getCellStyle().getDataFormat();
            Date date = cell.getDateCellValue();
            LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("ZoneId"));
            if (ArrayUtils.contains(DATE_TYPE_LIST, format)) {
                return DATE_FORMAT.format(dateTime);
            } else if (ArrayUtils.contains(TIME_TYPE_LIST, format)) {
                return TIME_FORMAT.format(dateTime);
            }
            return DATETIME_FORMAT.format(dateTime);
        }
        double d = cell.getNumericCellValue();
        String cellValue = Double.toString(d);
        if (cellValue.indexOf("E") > 0) {
            return new BigDecimal(d).toPlainString();
        }
        NumberFormat nf = NumberFormat.getInstance();
        cellValue = nf.format(d);
        if (cellValue.indexOf(",") >= 0) {
            cellValue = cellValue.replace(",", "");
        }
        return cellValue;
    }

    /**
     * @param sheet:   指定单元格
     * @param rowNum:  行号
     * @param cellNum: 列号
     * @param value:   值
     * @Description:给SHEET某一个单元格赋值
     * @author wangxiaoqi
     * @date 2020-06-08 12:58:53
     * @return: void
     **/
    public static void setCellValue(Sheet sheet, int rowNum, int cellNum, String value) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        if (cell == null) {
            row.createCell(cellNum).setCellValue(value);
        } else {
            cell.setCellValue(value);
        }
    }

    /**
     * @param sheet: 表单对象
     * @Description:还原合并区域的每个单元格的值
     * @author wangxiaoqi
     * @date 2020-06-08 12:59:25
     * @return: void
     **/
    public static void restoreMergedRegion(Sheet sheet) {
        //合并的单元格数量
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int y0 = range.getFirstRow();
            int x0 = range.getFirstColumn();
            int y1 = range.getLastRow();
            int x1 = range.getLastColumn();
            String value = getSheetCellValueByRowIndexAndColIndex(sheet, y0, x0);
            for (int j = y0; j <= y1; j++) {
                for (int k = x0; k <= x1; k++) {
                    setCellValue(sheet, j, k, value);
                }
            }
        }
    }

    /**
     * @param num: 索引
     * @Description:根据索引生成表头名称,A,B,C,D...
     * @author wangxiaoqi
     * @date 2020-06-08 12:59:45
     * @return: java.lang.String头名称
     **/
    public static String convertCharByIndex(int num) {
        int index = num / 26 - 1;
        if (index < 0) {
            return (char) (65 + index % 26) + "";
        } else if (index >= 0) {
            return (char) (65 + index) + "" + (char) (65 + index % 26) + "";
        }
        return "@";
    }

    /**
     * @param titleMap:
     * @param number:
     * @Description:生成表头名称 , 用第一列数据.
     * @author wangxiaoqi
     * @date 2020-06-08 13:00:05
     * @return: java.lang.String
     **/
    public static String getKey(Map<String, String> titleMap, int number) {
        int index = number / 26 - 1;
        String key = null;
        if (index < 0) {
            key = (char) (65 + number % 26) + "";
        } else if (index >= 0) {
            key = (char) (65 + index) + "" + (char) (65 + number % 26) + "";
        }

        return titleMap.get(key);
    }

    /**
     * @param fieldCodes: 字段编码列表
     * @param fieldNames: 字段名列表 - 与字段编码一一对应
     * @param data:       数据列表 - Key为字段编码
     * @param os:         输出流
     * @Description:写入excel工作薄
     * @author wangxiaoqi
     * @date 2020-06-08 13:00:18
     * @return: void
     **/
    public static <T> void writeWorkbook(String[] fieldCodes, String[] fieldNames, List<T> data, OutputStream os) {
        // 字节流传输
        Workbook workbook = null;
        try (OutputStream bufferedOutput = new BufferedOutputStream(os)) {
            workbook = createWorkbook(fieldCodes, fieldNames, data);
            workbook.write(bufferedOutput);
        } catch (IOException e) {
            log.error("写入excel异常", e);
            throw new RuntimeException("写入excel异常：", e);
        } finally {
            if (workbook instanceof SXSSFWorkbook) {
                ((SXSSFWorkbook) workbook).dispose();
            }
        }
    }

    /**
     * @param fieldCodes: 字段编码列表
     * @param fieldNames: 字段名列表 - 与字段编码一一对应
     * @param data:       数据列表 - Key为字段编码
     * @Description:生成excel内容
     * @author wangxiaoqi
     * @date 2020-06-08 13:00:53
     * @return: org.apache.poi.ss.usermodel.Workbook
     **/
    private static <T> Workbook createWorkbook(String[] fieldCodes, String[] fieldNames, List<T> data) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(workbook, 100);
        sxssfWorkbook.createSheet();

        //Workbook workbook = new XSSFWorkbook();
        CellStyle cellStyleHead = buildRowCellStyle(workbook, true);
        CellStyle cellStyle = buildRowCellStyle(workbook, false);
        // 产生工作表对象
        Sheet sheet = sxssfWorkbook.getSheetAt(0);
        //增加默认列宽
        sheet.setDefaultColumnWidth(20);
        // 产生一行
        final Row rowItemCode = sheet.createRow(0);
        for (int i = 0; i < fieldNames.length; i++) {
            CellUtil.createCell(rowItemCode, i, fieldNames[i], cellStyleHead);
//            Cell cell = rowItemCode.createCell(i);
//            cell.setCellType(CellType.STRING);
//            cell.setCellValue(fieldNames[i]);
//            cell.setCellStyle(cellStyleHead);
        }
        if (data == null || data.size() == 0) {
            autoAdaptColumnWidth(sheet, fieldCodes.length);
            return workbook;
        }
        boolean isMap = data.get(0) instanceof Map;
        if (isMap) {
            for (int i = 0; i < data.size(); i++) {
                // 产生一行
                final Row rowItem = sheet.createRow(i + 1);
                Map rowData = (Map) data.get(i);
                for (int j = 0; j < fieldNames.length; j++) {
                    Object value = rowData.get(fieldCodes[j]);
                    if (value instanceof Boolean) {
                        value = (Boolean) value ? "是" : "否";
                    }
                    CellUtil.createCell(rowItem, j, value == null ? "" : value.toString(), cellStyle);
                    //writeCell(rowItem.createCell(j), cellStyle, );
                }
            }
        } else {
//            BeanProxy proxy = BeanProxyBuilder.createBeanProxy(data.get(0));
//            for (int i = 0; i < data.size(); i++) {
//                // 产生一行
//                final Row rowItem = sheet.createRow(i + 1);
//                proxy.setSource(data.get(i));
//                for (int j = 0; j < fieldNames.length; j++) {
//                    Object value = proxy.get(fieldCodes[j]);
//                    if (value instanceof Boolean) {
//                        value = (Boolean) value ? "是" : "否";
//                    }
//                    CellUtil.createCell(rowItem, j, value == null ? "" : value.toString(), cellStyle);
////                    writeCell(rowItem.createCell(j), cellStyle, proxy.get(fieldCodes[j]));
//                }
//            }
        }
        ///sheet.setColumnWidth(i, fieldName[i].getBytes().length * 2 * 256);
        ///sheet.setAutoFilter(CellRangeAddress.valueOf("C1:D1"));
        // sheet的自动调整针对字母和数字有效，中文会有失效情况
        //autoAdaptColumnWidth(sheet,fieldCodes.length);
        return sxssfWorkbook;
    }

    /**
     * @param sheet:            表对象
     * @param columnCount:调整的列数
     * @Description:自动调整表列宽
     * @author wangxiaoqi
     * @date 2020-06-08 13:01:17
     * @return: void
     **/
    public static void autoAdaptColumnWidth(Sheet sheet, int columnCount) {
        for (int j = 0; j < columnCount; j++) {
            sheet.autoSizeColumn(j);
        }
        // 获取当前列的宽度，然后对比本列的长度，取最大值
        for (int i = 0; i < columnCount; i++) {
            int columnWidth = sheet.getColumnWidth(i) / 256;
            int maxLen = 0;
            for (int j = 0; j <= sheet.getLastRowNum(); j++) {
                //当前行未被使用过
                Row currentRow = sheet.getRow(j) == null ? sheet.createRow(j) : sheet.getRow(j);
                Cell currentCell = currentRow.getCell(i);
                try {
                    int num = currentCell != null ? currentCell.toString().getBytes(StandardCharsets.UTF_8.name()).length : 0;
                    if (maxLen < num) {
                        maxLen = num;
                    }
                } catch (UnsupportedEncodingException e) {
                    log.warn("调整Excel列失效", e);
                }
            }
            columnWidth = columnWidth > maxLen ? columnWidth : maxLen;
            sheet.setColumnWidth(i, (columnWidth * 256) + 10);
        }
    }

    /**
     * @param cell:      单元格
     * @param cellStyle: 单元格样式
     * @param value:     写入值
     * @Description:写入数据到指定单元格
     * @author wangxiaoqi
     * @date 2020-06-08 13:01:35
     * @return: void
     **/
    private static void writeCell(Cell cell, CellStyle cellStyle, Object value) {
        if (value == null) {
            value = "";
        }
        cell.setCellType(CellType.STRING);
        cell.setCellValue(String.valueOf(value));
        cell.setCellStyle(cellStyle);
    }

    /**
     * @param wb:
     * @param isHead:
     * @Description:表头式样 边框
     * @author wangxiaoqi
     * @date 2020-06-08 13:02:09
     * @return: org.apache.poi.ss.usermodel.CellStyle
     **/
    public static CellStyle buildRowCellStyle(Workbook wb, boolean isHead) {
        CellStyle style = wb.createCellStyle();
        ///style.setFillBackgroundColor(HSSFCellStyle.LEAST_DOTS);
        ///style.setFillPattern(HSSFCellStyle.LEAST_DOTS);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.index);
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.index);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.index);
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.index);
        style.setFillPattern(FillPatternType.LEAST_DOTS);

        Font font = wb.createFont();
        // 字体高度
        font.setFontHeightInPoints((short) 11);
        // 字体
        font.setFontName(" 黑体 ");
        style.setFont(font);
        if (isHead) {
            // 设置背景色
            style.setFillForegroundColor(IndexedColors.YELLOW.index);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        } else {
            style.setFillForegroundColor(IndexedColors.WHITE.index);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return style;
    }

    /**
     * @param wb:
     * @param isError:
     * @Description:表头式样 边框
     * @author wangxiaoqi
     * @date 2020-06-08 13:02:23
     * @return: org.apache.poi.ss.usermodel.CellStyle
     **/
    public static CellStyle buildRowCellFont(Workbook wb, boolean isError) {
        CellStyle style = wb.createCellStyle();
        ///style.setFillBackgroundColor(HSSFCellStyle.LEAST_DOTS);
        ///style.setFillPattern(HSSFCellStyle.LEAST_DOTS);
        style.setAlignment(HorizontalAlignment.CENTER);
        Font font = wb.createFont();
        if (isError) {
            font.setColor(IndexedColors.RED.index);
        } else {
            font.setColor(IndexedColors.BLACK.index);
        }
        // 字体高度
        font.setFontHeightInPoints((short) 11);
        // 字体
        font.setFontName(" 黑体 ");
        style.setFont(font);
        return style;
    }

    public static void main(String[] args) throws Exception {

        Date date = new Date();

        String dateStr = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("ZoneId")));
        System.out.println(dateStr);
//        Workbook workbook = getExcelWorkbook("D:/test/aa.xlsx");
//        Sheet sheet = getSheetByNum(workbook, 1);
//        System.out.println(JsonUtil.toJsonString(getSheetDataMapAndId(sheet)));
    }


}