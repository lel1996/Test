package com.lierlin;

import com.lierlin.service.UserService;
import com.lierlin.service.UserServicetoZj;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        //XMLʵ��aop
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.find();*/
        //ע��ʵ��aop
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContexttoZhuJie.xml");
        UserServicetoZj userServicetoZj = (UserServicetoZj) applicationContext.getBean("userServicetoZj");
        userServicetoZj.add();

    }
}
