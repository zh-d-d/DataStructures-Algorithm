package com.zhangdd.hashtable;

import java.util.Scanner;

/**
 * @author zhangdd on 2021/11/10
 */
public class HashTableExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable hashTable = new HashTable(8);

        while (true) {
            System.out.println("add:   添加");
            System.out.println("remove:删除");
            System.out.println("list:  展示");
            System.out.println("exit:  退出");
            String key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入ID");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    HashTable.Node node = new HashTable.Node(id, name);
                    hashTable.add(node);
                    break;
                case "remove":
                    System.out.println("输入ID");
                    id = scanner.nextInt();
                    hashTable.remove(id);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}
