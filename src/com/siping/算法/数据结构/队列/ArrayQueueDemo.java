package com.siping.算法.数据结构.队列;

import java.util.Scanner;

/**
 * @author Yang Xu
 * @date 2020/8/26 8:37
 * @description:
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("p(push): 添加数据到队列");
            System.out.println("g(pop): 从队列取数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    System.out.println("退出...");
                    loop = false;
                case 'p':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    try {
                        queue.push(value);
                    } catch (Exception e) {
                        System.out.println("队列已满...");
                    }
                    break;
                case 'g':
                    int v = 0;
                    try {
                        v = queue.pop();
                    } catch (Exception e) {
                        System.out.println("队列为空...");
                    }
                    System.out.println("取出的数据为：" + v);
                    break;
                case 'h':
                    int front = queue.showFront();
                    System.out.println("队列头的数据：" + front);
                    break;
            }
        }
    }

    static class ArrayQueue {
        // 最大容量
        private int maxSize;
        // 队列头
        private int front;
        // 队列尾
        private int rear;
        // 存放数据
        private int[] arr;

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            this.front = 0;
            this.rear = 0;
            this.arr = new int[maxSize];
        }

        public boolean isFull() {
            return rear == maxSize - 1;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public void push(int value) {
            if (isFull()) {
                throw new RuntimeException("队列已满");
            }
            arr[rear] = value;
            rear++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("队列没有数据");
            }
            int value = arr[front];
            front++;
            return value;
        }

        /**
         * 遍历打印队列
         */
        public void showQueue() {
            for (int i = front; i <= rear; i++) {
                System.out.printf("arr[%d]=%d\t", i, arr[i]);
            }
        }

        /**
         * 显示头部数据
         *
         * @return
         */
        public int showFront() {
            return arr[front];
        }
    }

}
