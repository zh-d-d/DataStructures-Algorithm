package com.zhangdd.hashtable;

/**
 * @author zhangdd on 2021/11/10
 */
public class HashTable {

    private final LinkList[] lists;

    public HashTable(int size) {
        lists = new LinkList[size];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkList();
        }
    }

    public void add(Node node) {
        int linkIndex = getLinkIndex(node.id);

        lists[linkIndex].add(node);

    }

    public void remove(int id) {
        int linkIndex = getLinkIndex(id);
        lists[linkIndex].remove(id);
    }

    public void list() {
        for (int i = 0; i < lists.length; i++) {
            lists[i].list();
        }
    }

    private int getLinkIndex(int id) {
        return id % lists.length;
    }


    public static class Node {
        private int id;
        private String name;
        private Node next;

        public Node(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private static class LinkList {
        private Node head;

        public void add(Node node) {
            if (null == head) {
                head = node;
                return;
            }
            Node temp = head;
            while (null != temp.next) {
                temp = temp.next;
            }
            temp.next = node;
        }

        public void remove(int id) {
            if (null == head) {
                return;
            }
            if (id == head.id) {
                head = head.next;
                return;
            }

            Node temp = head;
            while (true) {
                if (null == temp.next) {
                    break;
                }
                if (id == temp.next.id) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }

        }

        public void list() {
            Node temp = head;
            while (null != temp) {
                System.out.print("id:" + temp.id + ",name:" + temp.name);
                temp = temp.next;
            }
            System.out.println();
        }
    }

}
