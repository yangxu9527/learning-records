package com.siping.并发.并发编程实战.chapter5;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListSample {

    /**
     * Vector是增删改查方法都加了synchronized，保证同步，但是每个方法执行的时候都要去获得锁，性能就会大大下降，而CopyOnWriteArrayList
     * 只是在增删改上加锁，但是读不加锁，在读方面的性能就好于Vector，CopyOnWriteArrayList支持读多写少的并发情况。
     */
    @Test
    public void test() {
        List list = new CopyOnWriteArrayList();
    }
}
