package com.lierlin.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;
/*ReenTrantLock�����߳�����*/
public class ReenTrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("���̵߳ķ���");
        Thread.sleep(1000);
        m1();
    }
    public static void m1() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("������m1�ķ���");
            Thread.sleep(1000);
            m2();
        }finally {
            lock.unlock();
        }
    }
    public static void m2(){
        lock.lock();
        try{
            System.out.println("������m2�ķ���");
        }finally {
            lock.unlock();
        }

    }
}
