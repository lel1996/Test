package com.lierlin.ThreadTest;

public class WaitNotifyTest {
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (lock){
                System.out.println("执行。。。。。。");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("其它代码执行了........");
            }
        }).start();

        new Thread(()->{
            synchronized (lock){
                System.out.println("执行。。。。。。");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("其他代码执行了");

            }
        }).start();
        Thread.sleep(2000);
        synchronized (lock){
           // lock.notify();

            lock.notifyAll();
        }
    }
}
