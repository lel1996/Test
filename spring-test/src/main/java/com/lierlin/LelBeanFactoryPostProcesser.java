package com.lierlin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class LelBeanFactoryPostProcesser implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
     /* GenericBeanDefinition person = (GenericBeanDefinition) beanFactory.getBeanDefinition("person");
        Class<?> beanClass = person.getBeanClass();
        System.out.println("lierlin"+beanClass);
        System.out.println("123");*/

    }
}
