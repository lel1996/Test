package com.lidalin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
    public MyBeanPostProcessor(){
        System.out.println("����BeanPostProcessorʵ���๹��������");
    }
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor�ӿڷ���postProcessBeforeInitialization�����Խ��и���");
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor�ӿڷ���postProcessAfterInitialization�����Խ��и���");
        return o;
    }
}