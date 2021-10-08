package com.zhangdd.stack;

import java.util.Scanner;

/**
 * @author zhangdd on 2021/10/8
 */
public class ArrayStackExample {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show:显示栈内数据");
            System.out.println("exit:退出程序");
            System.out.println("push:数据入栈");
            System.out.println("pop :数据出栈");
            System.out.println("请操作:");
            key = scanner.next();
            switch (key) {
                case "show":
                    try {
                        stack.list();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "push": {
                    System.out.println("请输入一个数值:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                }
                case "pop": {
                    try {
                        int value = stack.pop();
                        System.out.printf("出栈的数据是:%d\n", value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }

        System.out.println("程序退出了");
    }
}
