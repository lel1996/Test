package com.lierlin.ThreadTest;

import java.util.concurrent.locks.LockSupport;

public class Park {
    public static void main(String[] args) {
        Thread a=new Thread(()->{
            LockSupport.park();
            System.out.println("T1");

        });
        a.start();

        new Thread(()->{
            System.out.println("T2");
            LockSupport.unpark(a);
        }).start();
    }
}
