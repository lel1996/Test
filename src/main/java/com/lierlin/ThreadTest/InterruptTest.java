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
                    // log.println("打断状态为："+interrupted);
                    log.print("t1一直在循环中打断状态为：" + interrupted);
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
            log.println("LockSupport在sleep状态下被打断的状态为" + Thread.currentThread().isInterrupted()+"打断 park 线程, 不会清空打断状态");
        });
        t1.start();
        t2.start();
        t3.start();
        t1.interrupt();
        log.println("t1线程在一直循环的时候打断状态为" + t1.isInterrupted());
        t2.interrupt();
        log.println("t2在sleep状态中打断状态为" + t2.isInterrupted());
        t3.interrupt();

    }

}
