package com.lierlin.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest1 {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread a=new Thread(()->{
            System.out.println("��ͼ��ȡ������");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(lock.tryLock());
            while (!lock.tryLock()){
                System.out.println("û�л��������");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }try {
                System.out.println("�����,��Ϣ1s");
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
        System.out.println("���̻߳����������˯����");
        Thread.sleep(2000);
        System.out.println("���߳̽�����������");
        lock.unlock();
        a.join();
    }
}
