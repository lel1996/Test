package com.beanInsert.constructor;

import com.beanInsert.constructor.SpringAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //Ĭ���ҵ���resources�µ������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config-constructor.xml");
        SpringAction springAction = (SpringAction) applicationContext.getBean("springAction");
        springAction.save();
        System.out.println(springAction.getClass());
    }

}
