package com.lierlin.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread a=new Thread(()->{
            System.out.println("试图获取锁。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(lock.tryLock());
            while (!lock.tryLock()){
                System.out.println("没有获得锁。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }try {
                System.out.println("获得锁,休息1s");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t1");
        a.start();
        //System.out.println("main"+lock.tryLock());
        lock.lock();
        System.out.println("主线程获得了锁——睡两秒");
        Thread.sleep(2000);
        System.out.println("主线程结束。。。。");
        lock.unlock();
        a.join();
    }
}
