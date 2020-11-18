package com.lierlin.集合.Connection.线程安全;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 验证HashMap不是线程安全
 * 如果需要保证线程安全的场景：
 * 1.将HashSet或HashMap转换为线程安全，使用Collections.synchronizedSet或Collections.synchronizedMap方法；
 * 2.使用Collections.newSetFromMap(new ConcurrentHashMap<Integer, Boolean>())或使用java.util.concurrent包下的ConcurrentHashMap；
 * 3.仍然使用HashSet或HashMap，使用时手动进行加锁或同步；// 注意加锁粒度，尽可能保证性能
 * 在项目中根据实际场景进行选择和应用。
 *
 * @author cdfive
 * @date 2019-02-11
 */
public class HashMapTest {
    public static void main(String[] args) {
        final Map<Integer, Integer> map = new HashMap<>();// 结果可能大于1000
//        final Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());// 结果等于1000
//        final Map<Integer, Integer> map = new ConcurrentHashMap<>();// 结果等于1000

        // 往map写入1-1000, key和value相同
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    map.put(i, i);
                }
            }
        };

        int threadNum = 2;// 线程数
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

        System.out.println(map.size());// 结果可能大于1000
    }
}