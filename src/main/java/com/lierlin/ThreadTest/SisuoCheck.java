package com.lierlin.ThreadTest;

public class SisuoCheck {

    public static void main(String[] args) throws InterruptedException {
    ThreadOne threadOne = new ThreadOne();
        for (int i = 0; i < 1000; i++) {
            threadOne.thread2.start();
            threadOne.thread1.start();
        }

    threadOne.thread1.join();
    threadOne.thread2.join();

    }
    static class ThreadOne{
         Object a = new Object();
         Object b = new Object();
         Thread thread1 =new Thread(()->{
             synchronized (a){
                 System.out.println("Lock   A");
                 try {
                     Thread.sleep(10);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
               synchronized (b){
                     System.out.println("Lock   B");
                     try {
                         Thread.sleep(10);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         },"t1");

         Thread thread2 =new Thread(()->{
             synchronized (a){
                 System.out.println("Lock 2A");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             synchronized (b){
                 System.out.println("Lock 2B");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         });
    }
}
