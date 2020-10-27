package com.wxq.poi.test;

/**
 * @author wangxiaoqi
 * @Description TODO
 * @date 2020-06-08 21:46
 */

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试短信验证码
 */

public class SendSms {
    public static void main(String[] args) {
        //连接阿里云
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FxzUGR4AwCdGDsmm953", "0cI2uyasMbi5lpzmhH33WVxhbbHVer");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        //自定义参数（手机号、验证码、签名，模板）
        request.putQueryParameter("PhoneNumbers", "15516215098");
        request.putQueryParameter("SignName", "Demi");
        request.putQueryParameter("TemplateCode", "SMS_192542261");
        //构建一个短信验证码
        Map<String,Object> map=new HashMap<>();
        map.put("code",2233);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}