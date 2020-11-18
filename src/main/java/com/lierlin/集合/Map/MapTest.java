package com.lierlin.����.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    private final static Logger logger = LoggerFactory.getLogger(MapTest.class);
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map map1 = new ConcurrentHashMap(32);
        System.out.println(0x7fffffff);
        for (int i = 0; i < 4; i++) {
            map.put("map" + i, "map" + i);

        }
        MapTest mapTest = new MapTest();
        mapTest.one(map);
        mapTest.two(map);
        mapTest.three(map);
        mapTest.four(map);
    }

    public void one(Map<String, String> map) {
        System.out.println("��һ�ַ���:��ȡmap�е�����ֵ�����ǵò���map�е�key");
        logger.debug("123456");
        for (String value : map.values()) {
            System.out.println("value:" + value);
        }
    }

    public void two(Map<String, String> map) {
        System.out.println("------------------------------");
        System.out.println("�ڶ��з���:��õķ���ѭ��map�е�key,ѭ��ÿ��key��ȡ��Ӧ��ֵ");
        for (String key : map.keySet()) {
            System.out.println("key:" + key + "------------>value:" + map.get(key));
        }

    }

    public void three(Map<String, String> map) {
        System.out.println("----------------------------");
        System.out.println("�����ַ���:��mapת����set���ϣ�ʹ����ǿforֱ�ӱ��������е�����");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + "---------->value" + entry.getValue());
        }
    }

    public void four(Map<String, String> map) {
        System.out.println("--------------------------");
        System.out.println("�����ַ���:��mapת����set����,ʹ��set�ĵ������������ڲ�֪��key������±���Map����");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
            System.out.println("key:" + entry.getKey() + "-------->value:" + entry.getValue());

        }
    }


}
