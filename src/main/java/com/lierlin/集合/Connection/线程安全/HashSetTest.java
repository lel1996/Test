package com.lierlin.集合.Connection.线程安全;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 验证HashSet不是线程安全
 *
 * @author cdfive
 * @date 2019-02-11
 */
public class HashSetTest {
    public static void main(String[] args) {
        final Set<Integer> set = new HashSet<>();// 结果可能大于1000
//        final Set<Integer> set = Collections.synchronizedSet(new HashSet<>());// 结果等于1000
//        final Set<Integer> set = Collections.newSetFromMap(new ConcurrentHashMap<Integer, Boolean>());// 结果等于1000

        // 往set写入1-1000
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    set.add(i);
                }
            }
        };

        int threadNum = 10;// 线程数
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(runnable);
            threadList.add(thread);
            thread.start();
        }

        // 主线程等待子线程执行完成
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(set.size());// 结果可能大于1000
    }
}