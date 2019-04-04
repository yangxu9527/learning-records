package com.siping.并发.synchorized;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Xu.Yang
 * @date 2019/3/15 12 57
 * @desc: 并发带来的问题
 */
public class Demo1 implements Runnable {

    private static Demo1 demo1 = new Demo1();
    //static int i = 0;
    /**
     * atomic使用了sun.misc.Unsafe的CAS算法
     */
    static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo1);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i的值为：" + i + "执行时间：" + (System.currentTimeMillis() - l));
    }

    @Override
    public synchronized void run() {
        for (int j = 0; j < 1000000; j++) {
            i.addAndGet(1);
            //i++;
        }
    }
}
