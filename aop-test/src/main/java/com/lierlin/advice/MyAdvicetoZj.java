package com.lierlin.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAdvicetoZj {

    @Before("execution(* com.lierlin.service.*.*(..))")
    public void before(){
        System.out.println("����ִ��ǰ......");
    }
    @After("execution(* com.lierlin.service.*.*(..))")
    public void after(){
        System.out.println("����ִ�к�......");
    }

    @Around("execution(* com.lierlin.service.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("����ǰ....");
        //ִ�з���
        proceedingJoinPoint.proceed();
        System.out.println("���ƺ�....");
    }
}
