package com.siping.并发.并发编程实战.chapter3;

/**
 * 非线程安全，与其他问题相比失效值更容易出现：如果某个线程调用了get，另外一个线程调用set，
 * 那么正在调用get的线程可能会看到set更新后的值，也可能看不到。
 * 解决的办法是在 get和set方法都加上synchronized关键字，仅对set加仍不行，get还是可能看到失效的值,
 * 加锁的含义不仅仅局限于互斥行为，还包括内存的可见性。为了保证所有线程都能看到共享变量的新值，所有的读写操作都必须在同一个锁上同步
 *  volatile和锁的区别，volatile只能保证可见性，加锁机制即能保证原子性又能保证可见性。
 *  当且仅当满足以下条件时才使用volatile:
 *      1） 对变量的写入操作不依赖变量的当前值，或者能保证只有单个线程执行写入操作
 *      2） 该变量不会与其他变量一起纳入不变性条件中
 *      3） 访问变量时不需要加锁
 * @author siping-yx
 * @date 2017年11月17日
 * @version 1.0
 *
 */
public class MutableInteger {

    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}

