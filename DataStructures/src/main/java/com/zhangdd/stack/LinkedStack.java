package com.zhangdd.stack;

/**
 * @author zhangdd on 2021/10/8
 */
public class LinkedStack {
    private Node head = new Node(-1, null);
    private Node top = null;


    private boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Node temp = new Node(value, null);
        if (isEmpty()) {
            head.next = temp;
        } else {
            top.next = temp;
        }
        top = temp;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空");
        }
        Node temp = head;
        boolean emptyFlag = false;
        while (true) {
            if (temp.next == top) {
                if (temp == head) {
                    emptyFlag = true;
                }
                break;
            }
            temp = temp.next;
        }
        int value = top.value;
        if (emptyFlag) {
            top = null;
        } else {
            top = temp;
        }
        return value;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空");
        }
        Node temp = head.next;
        while (true) {
            System.out.printf("%d\n", temp.value);
            if (temp == top) {
                break;
            }
            temp = temp.next;
        }
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
