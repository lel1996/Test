package com.lierlin.����.Connection.List;

import java.util.List;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();//����һ����������ʹ���ڲ���������Ĵ�СΪ 10�����׼��������Ϊ�㡣
        vector.addElement("lierlin");//��ָ���������ӵ���������ĩβ�������С���� 1
        vector.addElement("lierlin");
        System.out.println(vector.capacity() );//���ش������ĵ�ǰ������
        //vector.clear();�Ӵ��������Ƴ�����Ԫ�ء�
        //clone() ����������һ��������
        //elementAt(int index)����ָ���������������
    }
}
