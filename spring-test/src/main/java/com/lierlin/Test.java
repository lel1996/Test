package com.lierlin;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        /*  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.getName());*/

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBean("person"));
        System.out.println(applicationContext.getBean("userService"));
        System.out.println(applicationContext.getBean("userService").getClass());
        /*Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.getName());*/
    }
}
