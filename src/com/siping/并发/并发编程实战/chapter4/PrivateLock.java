package com.siping.并发.并发编程实战.chapter4;

import com.siping.并发.并发编程实战.provider.Person;

/**
 * @author Xu.Yang
 * @date 2019/4/3 15 42
 * @desc: 使用私有的锁对象的优点是：私有的锁对象可以将锁封装起来，使客户代码无法得到锁。但客户代码可以通过共有方法来访问锁，以便参与到它
 * 的同步策略中。如果客户代码错误的获得了另一个锁对象的锁，那么可能会产生活跃性问题。
 * java的内置锁也被称为监视器锁
 */
public class PrivateLock {

    private final Object myLock = new Object();
    Person person;

    void someMethod() {
        synchronized (myLock) {
            // 访问或修改person的状态
        }
    }
}
