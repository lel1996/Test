package com.lierlin.ThreadTest;
/*
* Volite并不能保证修饰的变量是原子操作，它只是保证了被修饰变量在共享内存中的可见性，
* 当a线程读取到count时，在原来的基础上+1后还没来得及读取到主存，b线程就已经把还没
* 有更新过（+1）的count写到内存中，这样就和预想的结果不一样，所以volite并不是原子性操作
* * */
public class  VoliteTest extends Thread {
    public volatile static int count = 0;

    private static /*synchronized*/ void add() {//加上synchronize可以保证变量count的可见性。

        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count = "+count);

    }

    @Override
    public  void run() {
        add();
    }

}
class Run{
    public static void main(String[] args) throws InterruptedException {
        long current = System.currentTimeMillis();
        VoliteTest[] voliteTests = new VoliteTest[100];
        for (int i = 0; i < 100; i++)
            voliteTests[i] = new VoliteTest();
        for (int i = 0; i < 100; i++)
           voliteTests[i].start();
        long time = System.currentTimeMillis();
        Thread.sleep(1000);
        System.out.println("花费的时间："+(time - current));
    }

}
