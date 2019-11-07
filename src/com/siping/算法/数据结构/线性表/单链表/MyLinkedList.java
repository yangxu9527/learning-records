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

    /**
     * 指定位置新增元素
     *
     * @param index
     * @param data
     */
    public void add(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode previous = headNode.getNext();
        ListNode node = new ListNode(data);
        if (index == 0) {
            headNode.setNext(node);
            node.setNext(previous);
        } else {
            int j = 1;
            while (j < index) {
                previous = previous.getNext();
                j++;
            }
            node.setNext(previous.getNext());
            previous.setNext(node);
        }
        size++;
    }

    public void clear() {
        ListNode p, q;
        p = headNode.getNext();
        while (p.getNext() != null) {
            q = p.getNext();
            p.setNext(null);
            p = q;
        }
        headNode.setNext(null);
        size = 0;
        last = headNode;
    }

    public Object get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int j = 0;
        ListNode node = headNode.getNext();
        while (j < index) {
            node = node.getNext();
            j++;
        }
        return node.getData();
    }

    public int size() {
        return size;
    }
}
