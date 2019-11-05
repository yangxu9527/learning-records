package com.siping.算法.数据结构.线性表.单链表;

/**
 * @author Yang Xu
 * @date 2019/11/5 8:32
 * @description:
 */
public class MyLinkedList {

    private ListNode headNode = new ListNode();

    private ListNode last = headNode;

    private int size = 0;

    public void add(Object data) {
        ListNode node = new ListNode(data);
        if (size == 0) {
            headNode.setNext(node);
            last = node;
            size++;
        } else {
            last.setNext(node);
            last = node;
            size++;
        }
    }

    public void add(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            ListNode originNode = headNode.getNext();
        }

    }

    public Object get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int j = 0;
        ListNode node = headNode.getNext();
        while (j < index) {
            node = headNode.getNext();
            j++;
        }
        return node.getData();
    }

}
