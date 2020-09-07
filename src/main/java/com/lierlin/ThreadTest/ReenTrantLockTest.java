package com.lierlin.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;
/*ReenTrantLock满足线程重入*/
public class ReenTrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程的方法");
        Thread.sleep(1000);
        m1();
    }
    public static void m1() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("调用了m1的方法");
            Thread.sleep(1000);
            m2();
        }finally {
            lock.unlock();
        }
    }
    public static void m2(){
        lock.lock();
        try{
            System.out.println("调用了m2的方法");
        }finally {
            lock.unlock();
        }

    }
}
