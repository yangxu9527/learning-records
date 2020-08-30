package com.siping.算法.数据结构.链表;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "吴用");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);
        linkedList.list();
    }
}

/**
 * @author Yang Xu
 * @date 2020/8/30 9:00
 * @description: 定义singleLinkedList来管理英雄
 */
class SingleLinkedList {

    /**
     * 先初始化一个头结点，头结点不要动，不存放具体的数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 思路：当不考虑编号的顺序时
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 当退出while循环时，temp指向链表的最后
        temp.next = heroNode;
    }

    /**
     * 遍历显示
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

/**
 * @author Yang Xu
 * @date 2020/8/30 8:53
 * @description: 通过单链表实现水浒英雄榜
 */
class HeroNode {

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
