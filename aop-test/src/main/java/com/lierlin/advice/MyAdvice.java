package com.lierlin.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


public class MyAdvice {

    //ǰ��֪ͨ
    public void before(){
        System.out.println("����ǰ��֪ͨ!!");
    }
    //����֪ͨ
    public void afterReturning(){
        System.out.println("���Ǻ���֪ͨ(��������쳣�������)!!");
    }
    //����֪ͨ
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("���ǻ���֪֮ͨǰ�Ĳ���!!");
        Object proceed = pjp.proceed();//����Ŀ�귽��
        System.out.println("���ǻ���֪֮ͨ��Ĳ���!!");
        return proceed;
    }
    //�쳣֪ͨ
    public void afterException(){
        System.out.println("������!�����쳣��!!");
    }
    //����֪ͨ
    public void after(){
        System.out.println("���Ǻ���֪ͨ(�����쳣Ҳ�����)!!");
    }
}