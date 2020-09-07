package com.lierlin.ThreadTest;

public class WaitNotifyTest {
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (lock){
                System.out.println("ִ�С�����������");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("��������ִ����........");
            }
        }).start();

        new Thread(()->{
            synchronized (lock){
                System.out.println("ִ�С�����������");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("��������ִ����");

            }
        }).start();
        Thread.sleep(2000);
        synchronized (lock){
           // lock.notify();

            lock.notifyAll();
        }
    }
}
