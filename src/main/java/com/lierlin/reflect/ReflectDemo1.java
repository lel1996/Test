package com.lierlin.reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;

public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        //1.字节码层面用全类名
        Class clazz = Class.forName("com.lierlin.reflect.Person");
        System.out.println(clazz);
        //2.用内存中的类对象
        Class clazx = Person.class;
        System.out.println(clazx);
        //3.用new出的对象的get.class()
        Class clazc = new Person().getClass();
        System.out.println(clazc);
        //无论用哪种反射生成的类对象都是唯一的
        System.out.println(clazc == clazz);
        System.out.println(clazx == clazc);

        System.out.println("===========================");

        Field[] fields = clazc.getFields();//获取的都是public类型的成员变量
        for (Field field:fields) {
            System.out.println(field);
        }
        //获取成员变量a
        Field a = Person.class.getField("sex");
        Person person = new Person();
        Object value =a.get(person);
        System.out.println(value);
        //设置a的值
        a.set(person,"女");
        System.out.println(person);

        System.out.println("*************************************");
        Field[] privates = clazc.getDeclaredFields();//获取的都是public类型的成员变量
        for (Field field:privates) {
            System.out.println(field);
        }

        Field field =Person.class.getDeclaredField("name");
        //忽略访问权限修饰符的安全检查
        field.setAccessible(true);//暴力反射
        Object value2 = field.get(person);
        field.set(person,"lierlin");
        System.out.println(person);
        System.out.println(value2);

        Constructor constructor = Person.class.getConstructor(String.class,int.class,String.class);
        Object pson =constructor.newInstance("lidalin",24,"男");
        System.out.println(pson);


        System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");

        Method method = new Person().getClass().getMethod("eat");
        Person person1 = new Person();
        method.invoke(person1);

        Method method1 = new Person().getClass().getMethod("eat",String.class);//反射有参方法
        method1.invoke(person1,"李二林");

        ClassLoader classLoader = Person.class.getClassLoader();
        URL resource = classLoader.getResource("com/lierlin/reflect");
        File file = new File(String.valueOf(resource));
        //System.out.println(resource+"1");
        System.out.println(file);
   /*   for (File fi:file)
          System.out.println(fi);*/
    }
}
