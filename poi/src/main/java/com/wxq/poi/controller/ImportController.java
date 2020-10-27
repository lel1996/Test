package com.wxq.poi.controller;

import com.wxq.poi.service.ImportService;
import com.wxq.poi.utils.PoiExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/**
 * @author wangxiaoqi
 * @Description TODO 导出没写
 * @date 2020-06-08 14:53
 */
@RestController
@Slf4j
public class ImportController {
    @Autowired
    private ImportService importService;

    @PostMapping("/importExcel")
    public Object importExcel( MultipartFile multipartFile){

        //获取excel数据
        String[][] excelData=null;
        try {
            Workbook workBook = PoiExcelUtils.getWorkBookByStream(multipartFile.getInputStream());
            String[][][] sheets=PoiExcelUtils.getWorkbookDatas(workBook);
            excelData=ArrayUtils.isEmpty(sheets)?null:sheets[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return importService.importInfo(excelData);
    }



}