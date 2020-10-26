package com.lierlin.CAS;

import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static void main(String[] args) {
        Student s1 = new Student(24,"dalin");
        Student s2 = new Student(15,"erlin");
        AtomicReference<Student> atomicReference = new AtomicReference();
        atomicReference.set(s1);
        System.out.println(atomicReference.compareAndSet(s1,s2)+"值"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(s1,s2)+"值"+atomicReference.get().toString());
    }
}
class Student{
    int age;
    String sex;

    public Student(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}