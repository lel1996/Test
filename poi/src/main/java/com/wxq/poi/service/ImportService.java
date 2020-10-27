package com.wxq.poi.service;

/**
 * @author wangxiaoqi
 * @Description TODO
 * @date 2020-06-08 15:01
 */
public interface ImportService {

    /**
     * 导入数据
     * @param excelData
     * @return
     */
    Object importInfo(String[][] excelData);
}