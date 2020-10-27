package com.wxq.poi.service.impl;

import com.wxq.poi.data.User;
import com.wxq.poi.service.ImportService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxiaoqi
 * @Description TODO
 * @date 2020-06-08 15:02
 */
@Service
public class ImportServiceImpl implements ImportService {

    @Override
    public Object importInfo(String[][] excelData) {
        List<User> voList = new ArrayList<>();
        String hintMsg="本次成功导入{0}人{1}条数据";
        StringBuffer errMsg = new StringBuffer();
        // 从第1行开始读取
        for(int i = 0;i < excelData.length;i++) {
            String[] row = excelData[i];
            String psnName = row[1];
            StringBuffer rowErrorMsg = new StringBuffer();
            // 组装VO
            User vo = new User();
            vo.setName(row[0]);
            vo.setAge(row[1]);
            vo.setAddress(row[2]);
            vo.setSex(row[3]);

            // 处理错误信息
            if(rowErrorMsg.length() > 0) {
                errMsg.append(MessageFormat.format("第{0}行{1}", i+1, rowErrorMsg.toString()));
                continue;
            }
            voList.add(vo);
            if(errMsg.length() > 0) {
                String showMsg = MessageFormat.format("数据内容校验：\n{0}", errMsg);
                throw new RuntimeException(showMsg, null);
            }
        }
        System.out.println(voList);
        return voList;
    }



}