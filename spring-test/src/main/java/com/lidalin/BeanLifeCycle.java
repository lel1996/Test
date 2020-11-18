package com.lidalin;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

    public static void main(String[] args) {

        System.out.println("���ڿ�ʼ��ʼ������");
        /*
        *   XmlBeanFactory�ǵ��͵�BeanFactory��
            BeanFactory factory = new XmlBeanFactory("XXX.xml");
            ��ȡһ������mdzz��bean�������ʱ�����ʵ������
            factory.getBean("mdzz");
        * */
        //?�ص㣺������ʹ��BeanFactoryȥ��ȡBean��ʱ������ֻ��ʵ�����˸����������������е�bean��û�б�ʵ������������getBean��ʱ�򣬲Ż�ʵʱʵ������bean����
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config1.xml");
        System.out.println("������ʼ���ɹ�");
        //�õ�Preson����ʹ��
        Person person = factory.getBean("person",Person.class);
        System.out.println(person);

        System.out.println("���ڿ�ʼ�ر�������");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}