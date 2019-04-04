package com.siping.数据库.mysql;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Xu.Yang
 * @date 2019/3/28 14 11
 * @desc: mysql的表锁和行锁，innodb支持行锁，myISAM只支持表锁。如果where条件中只用到索引项，则加的是行锁；否则加的是表锁。
 */
public class TestLock {

    public static void main(String[] args) throws InterruptedException {
        //创建线程池，里面有10个线程，共执行100次+1操作
        final int THREAD_COUNT = 10;
        final int RUN_TIME = 100;

        long l = System.currentTimeMillis();

        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
        //用CountDownLatch保证主线程等待所有任务完成
        CountDownLatch count = new CountDownLatch(RUN_TIME);

        for (int i = 0; i < RUN_TIME; i++)
            threadPool.execute(new LostUpdate(count));

        threadPool.shutdown();
        count.await();
        //提示所有任务执行完
        System.out.println("finish,执行时间：" + (System.currentTimeMillis() - l));
    }
}
