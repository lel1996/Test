package com.beanInsert.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //默认找的是resources下的配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config-set.xml");
        SpringAction springAction = (SpringAction) applicationContext.getBean("springAction");
        springAction.ok();
        System.out.println(springAction.getClass());
    }

}
