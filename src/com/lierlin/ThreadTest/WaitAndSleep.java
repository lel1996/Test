package com.lierlin.ThreadTest;

public class WaitAndSleep {
    static final Object lock = new Object();//�����final���α�֤��������ò��䡣
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (lock){

                try {
                    System.out.println("sleep��ʼִ�С����������ͷ����������߳���Ҫ��ȡ��������Ҫ�ȵ�10s");
                    Thread.sleep(10000);
                   // lock.wait(); wait�ͷ��������������߳��õ�lock��
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000);
        synchronized (lock){
            System.out.println("���̻߳��������������");
        }
    }
}
