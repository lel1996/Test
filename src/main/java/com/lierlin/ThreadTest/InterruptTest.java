package com.lierlin.ThreadTest;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                Thread t = Thread.currentThread();
                boolean interrupted = t.isInterrupted();
                if (interrupted) {
                    // log.println("���״̬Ϊ��"+interrupted);
                    log.print("t1һֱ��ѭ���д��״̬Ϊ��" + interrupted);
                    break;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            LockSupport.park();
            log.println("LockSupport��sleep״̬�±���ϵ�״̬Ϊ" + Thread.currentThread().isInterrupted()+"��� park �߳�, ������մ��״̬");
        });
        t1.start();
        t2.start();
        t3.start();
        t1.interrupt();
        log.println("t1�߳���һֱѭ����ʱ����״̬Ϊ" + t1.isInterrupted());
        t2.interrupt();
        log.println("t2��sleep״̬�д��״̬Ϊ" + t2.isInterrupted());
        t3.interrupt();

    }

}
