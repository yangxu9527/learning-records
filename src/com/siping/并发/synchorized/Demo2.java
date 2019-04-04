package com.siping.并发.synchorized;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Xu.Yang
 * @date 2019/4/4 10 30
 * @desc: 对象锁和类锁
 */
public class Demo2 implements Runnable {

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            this.method1();
        } else {
            this.method2();
        }
    }

    public synchronized static void method1() {
        System.out.println(1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    public synchronized static void method2() {
        System.out.println(3);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(4);
    }

    @Test
    public void test() {
        Demo2 demo2 = new Demo2();
        Thread t1 = new Thread(demo2);
        Thread t2 = new Thread(demo2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
