package com.lierlin.����.Connection.�̰߳�ȫ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ��֤HashMap�����̰߳�ȫ
 * �����Ҫ��֤�̰߳�ȫ�ĳ�����
 * 1.��HashSet��HashMapת��Ϊ�̰߳�ȫ��ʹ��Collections.synchronizedSet��Collections.synchronizedMap������
 * 2.ʹ��Collections.newSetFromMap(new ConcurrentHashMap<Integer, Boolean>())��ʹ��java.util.concurrent���µ�ConcurrentHashMap��
 * 3.��Ȼʹ��HashSet��HashMap��ʹ��ʱ�ֶ����м�����ͬ����// ע��������ȣ������ܱ�֤����
 * ����Ŀ�и���ʵ�ʳ�������ѡ���Ӧ�á�
 *
 * @author cdfive
 * @date 2019-02-11
 */
public class HashMapTest {
    public static void main(String[] args) {
        final Map<Integer, Integer> map = new HashMap<>();// ������ܴ���1000
//        final Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());// �������1000
//        final Map<Integer, Integer> map = new ConcurrentHashMap<>();// �������1000

        // ��mapд��1-1000, key��value��ͬ
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    map.put(i, i);
                }
            }
        };

        int threadNum = 2;// �߳���
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(runnable);
            threadList.add(thread);
            thread.start();
        }

        // ���̵߳ȴ����߳�ִ�����
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(map.size());// ������ܴ���1000
    }
}