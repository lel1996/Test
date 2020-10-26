package com.lierlin.Connection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> arrayList = Collections.synchronizedList(new ArrayList<>());
        List<String> arrayList1 = new CopyOnWriteArrayList<>();
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                arrayList.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(arrayList);
            }).start();
        }


        Vector<String> vector = new Vector<>();
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                vector.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(vector);
            }).start();
        }
    }



}
