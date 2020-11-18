package com.lidalin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private String address;
    private int phone;
    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("��������������Person�Ĺ�����ʵ����");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("��ע�����ԡ�name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("��ע�����ԡ�address");
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        System.out.println("��ע�����ԡ�phone");
        this.phone = phone;
    }

    // ����BeanFactoryAware�ӿڷ���
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("��BeanFactoryAware�ӿڡ�����setBeanFactory����");
        this.beanFactory = beanFactory;
    }

    // ����BeanNameAware�ӿڷ���
    public void setBeanName(String s) {
        System.out.println("��BeanNameAware�ӿڡ�����setBeanName����");
        this.beanName = s;
    }

    // ����DiposibleBean�ӿڷ���
    public void destroy() throws Exception {
        System.out.println("��DiposibleBean�ӿڡ�����destroy����");
    }

    // ����InitializingBean�ӿڷ���
    public void afterPropertiesSet() throws Exception {
        System.out.println("��InitializingBean�ӿڡ�����afterPropertiesSet����11111111");
    }

    // ͨ��<bean>��init-method����ָ���ĳ�ʼ������
    public void myInit() {
        System.out.println("��init-method������<bean>��init-method����ָ���ĳ�ʼ������");
    }

    // ͨ��<bean>��destroy-method����ָ���ĳ�ʼ������
    public void myDestory() {
        System.out.println("��destroy-method������<bean>��destroy-method����ָ���ĳ�ʼ������");
    }
}