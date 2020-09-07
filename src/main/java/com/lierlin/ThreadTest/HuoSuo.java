package com.lierlin.ThreadTest;

public class HuoSuo {
    static int count = 10;

    public static void main(String[] args) {
        new Thread(() -> {
            while (count > 0) {
                count--;
                try {
                    Thread.sleep(200);
                    System.out.println(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (count < 20) {
                count++;
                try {
                    Thread.sleep(200);
                    System.out.println(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
