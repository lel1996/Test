package com.LogerAnnotation;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {


    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    //��Ӧ���Զ���ע�⣬��������д���ע��ʱ���ͻ������������
    @Loger(title="���ģ��",action="say���")
    public String sayHello() {
        log.info("HelloController sayHello:{}","hello world!");
        return "hello";
    }
}