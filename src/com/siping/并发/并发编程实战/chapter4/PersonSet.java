package com.siping.并发.并发编程实战.chapter4;

import com.siping.并发.并发编程实战.provider.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xu.Yang
 * @date 2019/4/3 15 17
 * @desc: PersonSet的状态由HashSet来管理的，而HashSet并非线程安全的，但由于mySet是私有的并且不会逸出，因此HashSet被封闭在PersonSet
 * 中。唯一能访问mySet的代码路径是addPerson与containsPerson，在执行它们时都要获得PersonSet上的锁。PersonSet的状态完全由它的内置锁保护，
 * 因而PersonSet是一个线程安全的类。
 * 但如果Person类是可变的，那么在访问从PersonSet中获得的Person对象时还需要额外的同步。要想安全的使用Person对象，最可靠的方法是使Person对象
 * 成为一个线程安全的类。另外也可以使用锁来保护Person对象，并确保所有代码在访问Person对象前都已正确获得锁
 */
public class PersonSet {

    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }
}
