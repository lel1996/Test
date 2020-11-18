package com.lierlin.excel.easy;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class test {
    String path="C:\\study\\jdbcTest\\src\\main\\java\\com\\lierlin\\excel\\easy\\";
    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("�ַ���" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    /**
     * ��򵥵�д
     * <p>1. ����excel��Ӧ��ʵ����� ����{@link DemoData}
     * <p>2. ֱ��д����
     */
    @Test
    public void simpleWrite() {
        // д��1
        String fileName = path + "1.xlsx";
        // ���� ��Ҫָ��д���ĸ�classȥд��Ȼ��д����һ��sheet������Ϊģ�� Ȼ���ļ������Զ��ر�
        // ���������ʹ��03 �� ����excelType��������
        EasyExcel.write(fileName, DemoData.class).sheet("ģ��").doWrite(data());

     /*   // д��2
        fileName = "test.xlsx";
        // ���� ��Ҫָ��д���ĸ�classȥд
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("ģ��").build();
            excelWriter.write(data(), writeSheet);
        } finally {
            // ǧ�������finish ���æ�ر���
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }*/
    }



    /**
     * ��򵥵Ķ�
     * <p>1. ����excel��Ӧ��ʵ����� ����{@link DemoData}
     * <p>2. ����Ĭ��һ���еĶ�ȡexcel��������Ҫ����excelһ��һ�еĻص�������������{@link DemoDataListener}
     * <p>3. ֱ�Ӷ�����
     */
    @Test
    public void simpleRead() {
        // �и�����Ҫ�ĵ� DemoDataListener ���ܱ�spring����Ҫÿ�ζ�ȡexcel��Ҫnew,Ȼ�������õ�spring���Թ��췽������ȥ
        // д��1��
        String fileName = path + "1.xlsx";
        // ���� ��Ҫָ�������ĸ�classȥ����Ȼ���ȡ��һ��sheet �ļ������Զ��ر�
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

        /*// д��2��
        fileName = path + "1.xlsx";
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } finally {
            if (excelReader != null) {
                // ����ǧ������ǹرգ�����ʱ��ᴴ����ʱ�ļ�����ʱ���̻����
                excelReader.finish();
            }
        }*/
    }
}
