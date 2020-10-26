package com.lierlin.Test;

public class CloneAndNew {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person a = new Person();
        Person a1 = (Person)a.clone();
        System.out.println("a.equals(a1)->"+a.equals(a1)+"hashcode->"+a.hashCode());
        System.out.println("a==a1->"+(a==a1)+"hashcode->"+a1.hashCode());

    }

}
class Person implements Cloneable {
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}