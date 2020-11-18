package com.lierlin.excel.easy;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DemoData {
    @ExcelProperty("�ַ�������")
    private String string;
    @ExcelProperty("���ڱ���")
    private Date date;
    @ExcelProperty("���ֱ���")
    private Double doubleData;
    /**
     * ��������ֶ�
     */
    @ExcelIgnore
    private String ignore;
}
