package com.siping.算法.数据结构.线性表.单链表;

import org.junit.Test;

/**
 * @author Yang Xu
 * @date 2019/10/29 8:42
 * @description:
 */
public class ListNodeDemo {


    /**
     * 查找元素
     */
    @Test
    public void getNode() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(0));
    }
}
