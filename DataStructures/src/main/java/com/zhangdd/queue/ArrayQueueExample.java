package com.zhangdd.queue;

import java.util.Scanner;

/**
 * @author zhangdd on 2021/9/23
 */
public class ArrayQueueExample {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        char key;

        while (loop) {
            System.out.println("e(exit):退出程序");
            System.out.println("s(show):显示数据");
            System.out.println("a(add) :添加数据");
            System.out.println("g(get) :获取数据");
            System.out.println("h(head):查看头部");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'e':
                    loop = false;
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入值:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头部的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }

        System.out.println("程序退出");
    }
}
