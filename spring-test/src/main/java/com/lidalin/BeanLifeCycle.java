package com.lidalin;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");
        /*
        *   XmlBeanFactory是典型的BeanFactory。
            BeanFactory factory = new XmlBeanFactory("XXX.xml");
            获取一个叫做mdzz的bean。在这个时候进行实例化。
            factory.getBean("mdzz");
        * */
        //?重点：当我们使用BeanFactory去获取Bean的时候，我们只是实例化了该容器，而该容器中的bean并没有被实例化。当我们getBean的时候，才会实时实例化该bean对象。
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config1.xml");
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person",Person.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}