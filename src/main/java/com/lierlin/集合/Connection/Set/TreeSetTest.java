package com.lierlin.集合.Connection.Set;

import java.util.Iterator;
import java.util.TreeSet;
/*
TreeSet是用来排序的, 可以指定一个顺序, 对象存入之后会按照指定的顺序排列
两种方式的区别:
TreeSet 构造函数什么都不传, 默认按照类中 Comparable 的顺序。
TreeSet 如果传入 Comparator, 优先按照 Comparator。
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
            //return 0;       //当compareTo方法返回 0  的时候集合中 只有一个元素
            //return 1;      //当compareTo方法返回 正数 的时候集合会 怎么存就怎么取
            return -1;      //当compareTo方法返回 负数 的时候集合会 倒序存储
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
