package com.lierlin.集合.Connection.Set;

import java.util.HashSet;
import java.util.Iterator;
/*
  public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
    K为我们添加的参数，V为一个Object的定值。
 请说说HashSet原理，并写程序证明
HashSet在存元素时，会调用对象的hashCode方法计算出存储位置，然后和该位置上所有的元素进行equals比较，
如果该位置没有其他元素或者比较的结果都为false就存进去，否则就不存。
这样的原理注定了元素是按照哈希值来找存储位置，所有无序，而且可以保证无重复元素
我们在往HashSet集合存储元素时，对象应该正确重写Object类的hashCode和equals方法
正因为这样的原理，HashSet集合是非常高效的。
比如，要查找集合中是否包含某个对象，首先计算对象的hashCode，折算出位置号，到该位置上去找就可以了，而不用和所有的元素都比较一遍

 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet hashSet =new HashSet();

        hashSet.add("1");
        hashSet.add("0");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("e");
        hashSet.add("f");
        hashSet.add("c");
        hashSet.add("d");
        hashSet.add("e");
        hashSet.add("f");
        hashSet.add("g");
        System.out.println(hashSet.size());
        System.out.println("---------------------------");
        Iterator iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());

        }
    }
}
