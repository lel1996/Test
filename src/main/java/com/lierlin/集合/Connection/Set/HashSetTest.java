package com.lierlin.����.Connection.Set;

import java.util.HashSet;
import java.util.Iterator;
/*
  public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
    KΪ������ӵĲ�����VΪһ��Object�Ķ�ֵ��
 ��˵˵HashSetԭ����д����֤��
HashSet�ڴ�Ԫ��ʱ������ö����hashCode����������洢λ�ã�Ȼ��͸�λ�������е�Ԫ�ؽ���equals�Ƚϣ�
�����λ��û������Ԫ�ػ��߱ȽϵĽ����Ϊfalse�ʹ��ȥ������Ͳ��档
������ԭ��ע����Ԫ���ǰ��չ�ϣֵ���Ҵ洢λ�ã��������򣬶��ҿ��Ա�֤���ظ�Ԫ��
��������HashSet���ϴ洢Ԫ��ʱ������Ӧ����ȷ��дObject���hashCode��equals����
����Ϊ������ԭ��HashSet�����Ƿǳ���Ч�ġ�
���磬Ҫ���Ҽ������Ƿ����ĳ���������ȼ�������hashCode�������λ�úţ�����λ����ȥ�ҾͿ����ˣ������ú����е�Ԫ�ض��Ƚ�һ��

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
