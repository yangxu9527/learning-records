package com.siping.leetcode.链表.util;

import com.siping.leetcode.链表.ListNode;

/**
 * @author Yang Xu
 * @date 2020/4/14 18:29
 * @description:
 */
public class ListUtil {

    public static ListNode createList(int[] poses) {
        ListNode headNode = new ListNode();
        ListNode nextNode = new ListNode();
        headNode.setNext(nextNode);
        for (int pos : poses) {
            ListNode listNode = new ListNode(pos);
            nextNode.setNext(listNode);
            nextNode=listNode;
        }
        return headNode;
    }
}
