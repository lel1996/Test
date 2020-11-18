package com.lierlin.集合.Connection.List;

import java.util.List;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();//构造一个空向量，使其内部数据数组的大小为 10，其标准容量增量为零。
        vector.addElement("lierlin");//将指定的组件添加到此向量的末尾，将其大小增加 1
        vector.addElement("lierlin");
        System.out.println(vector.capacity() );//返回此向量的当前容量。
        //vector.clear();从此向量中移除所有元素。
        //clone() 返回向量的一个副本。
        //elementAt(int index)返回指定索引处的组件。
    }
}
