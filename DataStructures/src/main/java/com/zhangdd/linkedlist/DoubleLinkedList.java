package com.zhangdd.linkedlist;

/**
 * @author zhangdd on 2021/9/29
 */
public class DoubleLinkedList {

    private Node head = new Node(0, null, null);

    public Node getHead() {
        return head;
    }

    public void list() {
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 添加节点到链表最后
     */
    public void add(Node node) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void addByOrder(Node node) {
        Node temp = head;
        boolean findNodeFlag = false;
        while (temp != null) {
            if (temp.next == null) {
                findNodeFlag = true;
                break;
            }
            if (temp.next.no > node.no) {
                findNodeFlag = true;
                break;
            }
            if (temp.next.no == node.no) {
                break;
            }
            temp = temp.next;
        }
        if (findNodeFlag) {
            node.next = temp.next;
            node.pre = temp;
            temp.next = node;
        }


    }

    /**
     * 修改节点
     */
    public void update(Node node) {
        Node temp = head.next;

        boolean findNodeFlag = false;
        while (temp != null) {
            if (temp.no == node.no) {
                findNodeFlag = true;
                break;
            }
            temp = temp.next;
        }
        if (findNodeFlag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        }
    }

    /**
     * 删除一个节点
     */
    public void del(int no) {
        Node temp = head.next;
        boolean findNodeFlag = false;
        while (temp != null) {
            if (temp.no == no) {
                findNodeFlag = true;
                break;
            }
            temp = temp.next;
        }
        if (findNodeFlag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
    }


    public static class Node {
        private Node next;
        private Node pre;
        private int no;
        private String name;
        private String nickname;

        public Node(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}
