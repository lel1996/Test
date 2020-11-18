package com.lierlin.����.Connection.Set;

import java.util.Iterator;
import java.util.TreeSet;
/*
TreeSet�����������, ����ָ��һ��˳��, �������֮��ᰴ��ָ����˳������
���ַ�ʽ������:
TreeSet ���캯��ʲô������, Ĭ�ϰ������� Comparable ��˳��
TreeSet ������� Comparator, ���Ȱ��� Comparator��
*/
public class TreeSetTest {
    static class Person implements Comparable<Person>{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
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
        public int compareTo(Person o) {
            //return 0;       //��compareTo�������� 0  ��ʱ�򼯺��� ֻ��һ��Ԫ��
            //return 1;      //��compareTo�������� ���� ��ʱ�򼯺ϻ� ��ô�����ôȡ
            return -1;      //��compareTo�������� ���� ��ʱ�򼯺ϻ� ����洢
        }
    }
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("lierlin",12));
        treeSet.add(new Person("lidalin",13));
        treeSet.add(new Person("lichunxia",14));
        treeSet.add(new Person("lidegong",15));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===========================");

    }
}
