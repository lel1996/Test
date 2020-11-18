package com.lierlin.reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;

public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        //1.�ֽ��������ȫ����
        Class clazz = Class.forName("com.lierlin.reflect.Person");
        System.out.println(clazz);
        //2.���ڴ��е������
        Class clazx = Person.class;
        System.out.println(clazx);
        //3.��new���Ķ����get.class()
        Class clazc = new Person().getClass();
        System.out.println(clazc);
        //���������ַ������ɵ��������Ψһ��
        System.out.println(clazc == clazz);
        System.out.println(clazx == clazc);

        System.out.println("===========================");

        Field[] fields = clazc.getFields();//��ȡ�Ķ���public���͵ĳ�Ա����
        for (Field field:fields) {
            System.out.println(field);
        }
        //��ȡ��Ա����a
        Field a = Person.class.getField("sex");
        Person person = new Person();
        Object value =a.get(person);
        System.out.println(value);
        //����a��ֵ
        a.set(person,"Ů");
        System.out.println(person);

        System.out.println("*************************************");
        Field[] privates = clazc.getDeclaredFields();//��ȡ�Ķ���public���͵ĳ�Ա����
        for (Field field:privates) {
            System.out.println(field);
        }

        Field field =Person.class.getDeclaredField("name");
        //���Է���Ȩ�����η��İ�ȫ���
        field.setAccessible(true);//��������
        Object value2 = field.get(person);
        field.set(person,"lierlin");
        System.out.println(person);
        System.out.println(value2);

        Constructor constructor = Person.class.getConstructor(String.class,int.class,String.class);
        Object pson =constructor.newInstance("lidalin",24,"��");
        System.out.println(pson);


        System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");

        Method method = new Person().getClass().getMethod("eat");
        Person person1 = new Person();
        method.invoke(person1);

        Method method1 = new Person().getClass().getMethod("eat",String.class);//�����вη���
        method1.invoke(person1,"�����");

        ClassLoader classLoader = Person.class.getClassLoader();
        URL resource = classLoader.getResource("com/lierlin/reflect");
        File file = new File(String.valueOf(resource));
        //System.out.println(resource+"1");
        System.out.println(file);
   /*   for (File fi:file)
          System.out.println(fi);*/
    }
}
