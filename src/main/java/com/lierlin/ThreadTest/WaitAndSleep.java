package com.lierlin.ThreadTest;

public class WaitAndSleep {
    static final Object lock = new Object();//最好用final修饰保证对象的引用不变。
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (lock){

                try {
                    System.out.println("sleep开始执行。。。并不释放锁对象，主线程想要获取锁对象需要等到10s");
                    Thread.sleep(10000);
                   // lock.wait(); wait释放锁，可以让主线程拿到lock锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(1000);
        synchronized (lock){
            System.out.println("主线程获得锁。。。。。");
        }
    }
}
