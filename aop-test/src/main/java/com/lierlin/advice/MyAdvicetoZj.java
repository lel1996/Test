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
        System.out.println("方法执行前......");
    }
    @After("execution(* com.lierlin.service.*.*(..))")
    public void after(){
        System.out.println("方法执行后......");
    }

    @Around("execution(* com.lierlin.service.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前....");
        //执行方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕后....");
    }
}
