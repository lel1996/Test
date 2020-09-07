package com.lierlin.ThreadTest;
/*
* Volite�����ܱ�֤���εı�����ԭ�Ӳ�������ֻ�Ǳ�֤�˱����α����ڹ����ڴ��еĿɼ��ԣ�
* ��a�̶߳�ȡ��countʱ����ԭ���Ļ�����+1��û���ü���ȡ�����棬b�߳̾��Ѿ��ѻ�û
* �и��¹���+1����countд���ڴ��У������ͺ�Ԥ��Ľ����һ��������volite������ԭ���Բ���
* * */
public class  VoliteTest extends Thread {
    public volatile static int count = 0;

    private static /*synchronized*/ void add() {//����synchronize���Ա�֤����count�Ŀɼ��ԡ�

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
        System.out.println("���ѵ�ʱ�䣺"+(time - current));
    }

}
