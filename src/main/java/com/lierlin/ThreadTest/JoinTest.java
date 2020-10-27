package com.lierlin.ThreadTest;

import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class JoinTest {
    static  int a = 10;
    static int b = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.println("a="+a);
        });
        Thread t2 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.println("b="+b);
        });
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t2.join();//等t2执行完才能执行主程序
        t1.join();

        long end = System.currentTimeMillis();
        log.print(end-start);
}
}
