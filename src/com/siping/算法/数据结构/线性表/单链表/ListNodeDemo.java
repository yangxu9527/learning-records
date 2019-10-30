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
        ListNode headNode = new ListNode();
        ListNode listNode = getListNode(0, 100, headNode);
        ListNode p = headNode;
        while (p.getNext() != null) {
            System.out.println(p.getData());
            p = p.getNext();
        }

    }

    /**
     * 生成一个单链表
     * @param count
     * @param size
     * @param listNode
     * @return
     */
    private ListNode getListNode(int count, int size, ListNode listNode) {
        ListNode node = new ListNode();
        listNode.setData(count);
        listNode.setNext(node);
        count++;
        if (count < size){
            getListNode(count, size, node);
        }
        return listNode;
    }
}
