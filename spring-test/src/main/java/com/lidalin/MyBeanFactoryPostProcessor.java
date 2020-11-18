package com.lidalin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private BeanFactory name;
    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("����BeanFactoryPostProcessorʵ���๹��������");
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor����postProcessBeanFactory����");
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("person");
        bd.getPropertyValues().addPropertyValue("phone", "110");
    }



}