package com.lierlin.ThreadTest;

public class ABCABCABC {


    public static void main(String[] args) throws InterruptedException {
        Print print = new Print(1, 5);
        Thread a = new Thread(() -> {
            print.shuChu("a", 1, 2);
        });
        Thread b = new Thread(() -> {
            print.shuChu("b", 2, 3);
        });
        Thread c = new Thread(() -> {
            print.shuChu("c", 3, 1);
        });
        a.start();b.start();c.start();
        Thread.sleep(4000);
        System.out.println("a线程的状态"+a.getState());
        System.out.println("b线程的状态"+b.getState());
        System.out.println("c线程的状态"+c.getState());
    }
}

class Print {
    private int flag;
    private int loop;

    public Print(int flag, int loop) {
        this.flag = flag;
        this.loop = loop;
    }

    public void shuChu(String str, int n, int m) {
       for (int i = 0; i < loop; i++) {
            synchronized (this) {
                while (flag != n) {
                    try {
                        this.wait();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("出现了错误");
                    }
                }
                System.out.print(str);
                flag = m;
                this.notifyAll();
           }
        }
    }
}