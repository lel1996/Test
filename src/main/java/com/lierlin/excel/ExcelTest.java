package com.lierlin.excel;
import com.grapecity.documents.excel.*;
import com.grapecity.documents.excel.drawing.*;
public class ExcelTest {
    public static void main(String[] args) {
//ͨ��GcExcel������һ��Excel�ļ��ĵ�һ�������ȴ���һ��������ʵ����
        Workbook workbook = new Workbook();
        IWorksheet worksheet = workbook.getWorksheets().get(0);
       // �ڸ�GcExcel���ô�������ʱ, ��Ҫ��׼��һ�����õĶ�ά���飬Ȼ�������ά���鸳ֵ����Ҫ�������ݵ�����

        worksheet.getRange("B3:C7").setValue(new Object[][]{
                {"ITEM", "AMOUNT"},
                {"Income 1", 2500},
                {"Income 2", 1000},
                {"Income 3", 250},
                {"Other", 250},
        });
        worksheet.getRange("B10:C23").setValue(new Object[][]{
                {"ITEM", "AMOUNT"},
                {"Rent/mortgage", 800},
                {"Electric", 120},
                {"Gas", 50},
                {"Cell phone", 45},
                {"Groceries", 500},
                {"Car payment", 273},
                {"Auto expenses", 120},
                {"Student loans", 50},
                {"Credit cards", 100},
                {"Auto Insurance", 78},
                {"Personal care", 50},
                {"Entertainment", 100},
                {"Miscellaneous", 50},
        });

        worksheet.getRange("B2:C2").merge();
        worksheet.getRange("B2").setValue("MONTHLY INCOME");
        worksheet.getRange("B9:C9").merge();
        worksheet.getRange("B9").setValue("MONTHLY EXPENSES");
        worksheet.getRange("E2:G2").merge();
        worksheet.getRange("E2").setValue("PERCENTAGE OF INCOME SPENT");
        worksheet.getRange("E5:G5").merge();
        worksheet.getRange("E5").setValue("SUMMARY");
        worksheet.getRange("E3:F3").merge();
        worksheet.getRange("E9").setValue("BALANCE");
        worksheet.getRange("E6").setValue("Total Monthly Income");
        worksheet.getRange("E7").setValue("Total Monthly Expenses");

       // ��ʱ��Ҫ���ú��ʵ��иߺ��п���������չʾ�ø��ã�����ʹ��Worksheet��StandardHeight��StandardWidth����������Ĭ�ϵ��иߺ��п�

        worksheet.setStandardHeight(26.25);
        worksheet.setStandardWidth(8.43);

        worksheet.getRange("2:24").setRowHeight(27);
        worksheet.getRange("A:A").setColumnWidth(2.855);
        worksheet.getRange("B:B").setColumnWidth(33.285);
        worksheet.getRange("C:C").setColumnWidth(25.57);
        worksheet.getRange("D:D").setColumnWidth(1);
        worksheet.getRange("E:F").setColumnWidth(25.57);
        worksheet.getRange("G:G").setColumnWidth(14.285);

        //�����������: "Income"��"Expenses"�����ֱ������������������õı����ʽ��

        ITable incomeTable = worksheet.getTables().add(worksheet.getRange("B3:C7"), true);
        incomeTable.setName("tblIncome");
        incomeTable.setTableStyle(workbook.getTableStyles().get("TableStyleMedium4"));

        ITable expensesTable = worksheet.getTables().add(worksheet.getRange("B10:C23"), true);
        expensesTable.setName("tblExpenses");
        expensesTable.setTableStyle(workbook.getTableStyles().get("TableStyleMedium4"));
        //���������Զ������������¶ȵ������֧���ֱ�����ͣ�Ȼ���ڵ�Ԫ����ʹ������������������ù�ʽ�������¶ȵ������ܺ��Լ�֧���ܺͣ��ٷֱ���������������ʽ��һ����ʽ������֧��ռ����İٷֱȣ�һ���������¶ȵľ����롣

        worksheet.getNames().add("TotalMonthlyIncome", "=SUM(tblIncome[AMOUNT])");
        worksheet.getNames().add("TotalMonthlyExpenses", "=SUM(tblExpenses[AMOUNT])");

        worksheet.getRange("E3").setFormula("=TotalMonthlyExpenses");
        worksheet.getRange("G3").setFormula("=TotalMonthlyExpenses/TotalMonthlyIncome");
        worksheet.getRange("G6").setFormula("=TotalMonthlyIncome");
        worksheet.getRange("G7").setFormula("=TotalMonthlyExpenses");
        worksheet.getRange("G9").setFormula("=TotalMonthlyIncome-TotalMonthlyExpenses");
       // ��������ǻ��޸����õ�һЩ������ʽ--"Currency" "Heading 1"��"Percent"��Ȼ���������Ӧ�õ�ĳ�������Ԫ�񣬶�������������������ֱ���޸��������ʽ���ԡ�

        IStyle currencyStyle = workbook.getStyles().get("Currency");
        currencyStyle.setIncludeAlignment(true);
        currencyStyle.setHorizontalAlignment(HorizontalAlignment.Left);
        currencyStyle.setVerticalAlignment(VerticalAlignment.Bottom);
        currencyStyle.setNumberFormat("$#,##0.00");

        IStyle heading1Style = workbook.getStyles().get("Heading 1");
        heading1Style.setIncludeAlignment(true);
        heading1Style.setHorizontalAlignment(HorizontalAlignment.Center);
        heading1Style.setVerticalAlignment(VerticalAlignment.Center);
        heading1Style.getFont().setName("Century Gothic");
        heading1Style.getFont().setBold(true);
        heading1Style.getFont().setSize(11);
        heading1Style.getFont().setColor(Color.GetWhite());
        heading1Style.setIncludeBorder(false);
        heading1Style.setIncludePatterns(true);
        heading1Style.getInterior().setColor(Color.FromArgb(32, 61, 64));

        IStyle percentStyle = workbook.getStyles().get("Percent");
        percentStyle.setIncludeAlignment(true);
        percentStyle.setHorizontalAlignment(HorizontalAlignment.Center);
        percentStyle.setIncludeFont(true);
        percentStyle.getFont().setColor(Color.FromArgb(32, 61, 64));
        percentStyle.getFont().setName("Century Gothic");
        percentStyle.getFont().setBold(true);
        percentStyle.getFont().setSize(14);

        worksheet.getSheetView().setDisplayGridlines(false);
        worksheet.getRange("C4:C7, C11:C23, G6:G7, G9").setStyle(currencyStyle);
        worksheet.getRange("B2, B9, E2, E5").setStyle(heading1Style);
        worksheet.getRange("G3").setStyle(percentStyle);

        worksheet.getRange("E6:G6").getBorders().get(BordersIndex.EdgeBottom).setLineStyle(BorderLineStyle.Medium);
        worksheet.getRange("E6:G6").getBorders().get(BordersIndex.EdgeBottom).setColor(Color.FromArgb(32, 61, 64));
        worksheet.getRange("E7:G7").getBorders().get(BordersIndex.EdgeBottom).setLineStyle(BorderLineStyle.Medium);
        worksheet.getRange("E7:G7").getBorders().get(BordersIndex.EdgeBottom).setColor(Color.FromArgb(32, 61, 64));

        worksheet.getRange("E9:G9").getInterior().setColor(Color.FromArgb(32, 61, 64));
        worksheet.getRange("E9:G9").setHorizontalAlignment(HorizontalAlignment.Left);
        worksheet.getRange("E9:G9").setVerticalAlignment(VerticalAlignment.Center);
        worksheet.getRange("E9:G9").getFont().setName("Century Gothic");
        worksheet.getRange("E9:G9").getFont().setBold(true);
        worksheet.getRange("E9:G9").getFont().setSize(11);
        worksheet.getRange("E9:G9").getFont().setColor(Color.GetWhite());
        worksheet.getRange("E3:F3").getBorders().setColor(Color.FromArgb(32, 61, 64));
        //GcExcel֧��Excel�������͵�������ʽ�����������ǻᴴ��һ�������������������ʽ���Կ��ӻ���չʾ֧������ȣ�����������Ϊֻ��ʾ������������ʾ��Ԫ���ֵ��

        IDataBar dataBar = worksheet.getRange("E3").getFormatConditions().addDatabar();
        dataBar.getMinPoint().setType(ConditionValueTypes.Number);
        dataBar.getMinPoint().setValue(1);
        dataBar.getMaxPoint().setType(ConditionValueTypes.Number);
        dataBar.getMaxPoint().setValue("=TotalMonthlyIncome");
        dataBar.setBarFillType(DataBarFillType.Gradient);
        dataBar.getBarColor().setColor(Color.GetRed());
        dataBar.setShowValue(false);
        IShape shape = worksheet.getShapes().addChart(ChartType.ColumnClustered, 339, 247, 316.5, 346);
        shape.getChart().getChartArea().getFormat().getLine().setTransparency(1);
        shape.getChart().getColumnGroups().get(0).setOverlap(0);
        shape.getChart().getColumnGroups().get(0).setGapWidth(37);

        IAxis category_axis = shape.getChart().getAxes().item(AxisType.Category);
        category_axis.getFormat().getLine().getColor().setRGB(Color.GetBlack());
        category_axis.getTickLabels().getFont().setSize(11);
        category_axis.getTickLabels().getFont().getColor().setRGB(Color.GetBlack());

        IAxis series_axis = shape.getChart().getAxes().item(AxisType.Value);
        series_axis.getFormat().getLine().setWeight(1);
        series_axis.getFormat().getLine().getColor().setRGB(Color.GetBlack());
        series_axis.getTickLabels().setNumberFormat("$###0");
        series_axis.getTickLabels().getFont().setSize(11);
        series_axis.getTickLabels().getFont().getColor().setRGB(Color.GetBlack());

        ISeries chartSeries = shape.getChart().getSeriesCollection().newSeries();
        chartSeries.setFormula("=SERIES(\"Simple Budget\",{\"Income\",\"Expenses\"},'Sheet1'!$G$6:$G$7,1)");
        chartSeries.getPoints().get(0).getFormat().getFill().getColor().setRGB(Color.FromArgb(176, 21, 19));
        chartSeries.getPoints().get(1).getFormat().getFill().getColor().setRGB(Color.FromArgb(234, 99, 18));
        chartSeries.getDataLabels().getFont().setSize(11);
        chartSeries.getDataLabels().getFont().getColor().setRGB(Color.GetBlack());
        chartSeries.getDataLabels().setShowValue(true);
        chartSeries.getDataLabels().setPosition(DataLabelPosition.OutsideEnd);
       // ������ǻὫWorkbook����Ϊһ����ΪSimpleBudget.xlsx��Excel�ļ���

        workbook.save("SimpleBudget.xlsx");

    }
}
