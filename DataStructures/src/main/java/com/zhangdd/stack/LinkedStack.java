package com.zhangdd.stack;

/**
 * @author zhangdd on 2021/10/8
 */
public class LinkedStack {
    private Node head = new Node(-1, null);
    private Node top = null;


    private boolean isEmpty() {
        return head.next == null;
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
            head.next = null;
            top = null;
        } else {
            top = temp;
            top.next = null;
        }
        return value;
    }

    /**
     * 先遍历原来的链表内容，构造出一个反转后的链表，然后顺序打印反转后的链表
     */
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空");
        }

        //遍历原来链表，构造一个反转链表
        LinkedStack newStack = new LinkedStack();

        Node currentNode = this.head.next;

        while (currentNode != null) {
            Node temp = new Node(currentNode.value, null);
            if (!newStack.isEmpty()) {
                temp.next = newStack.head.next;
            }
            newStack.head.next = temp;

            currentNode = currentNode.next;
        }

        //遍历反转后的链表
        Node temp = newStack.head.next;
        while (true) {
            System.out.printf("%d\n", temp.value);
            if (temp.next == null) {
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
