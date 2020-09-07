package com.lierlin.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
    public static void main(String[] args) {
    //�߳�һ
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("123456");
                return 5;
            }
        });

        //�̶߳�
        Thread two = new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("123456");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //�߳���
        Thread three = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123456");
            }
        });

        Thread one = new Thread(task);
        one.start();

        two.start();

        three.start();
    }


}
