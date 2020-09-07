package com.lierlin.ThreadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockABCABC {
    public static void main(String[] args) throws InterruptedException {
        ReenToAbc abc = new ReenToAbc(5);
        Condition a = abc.newCondition();
        Condition b = abc.newCondition();
        Condition c = abc.newCondition();
        new Thread(() -> {
            try {
                abc.print("a", a, b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                abc.print("b", b, c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                abc.print("c", c, a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
try {
    abc.lock();
    a.signal();
}finally {
    abc.unlock();
}

    }
}

class ReenToAbc extends ReentrantLock {
    private int lopper;

    public ReenToAbc(int lopper) {
        this.lopper = lopper;
    }

    public void print(String a, Condition current, Condition next) throws InterruptedException {

        for (int i = 0; i < lopper; i++) {
            lock();
            try {
                current.await();
                System.out.print(a);
                Thread.sleep(300);
                next.signal();
            } finally {
                unlock();
            }
        }


    }
}