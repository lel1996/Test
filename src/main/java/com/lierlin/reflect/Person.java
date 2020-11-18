package com.lierlin.reflect;

public class Person {
    private String name;
    private int age;
    public String sex;
public Person(){
    super();
}
    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
    public void eat(){
        System.out.println("通过反射拿到类中的方法");
    }
    public void eat(String msg){
        System.out.println("通过反射拿到类中的方法"+msg);
    }
}
