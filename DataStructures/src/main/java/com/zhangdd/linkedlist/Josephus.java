package com.zhangdd.linkedlist;

/**
 * 约瑟夫环问题
 *
 * @author zhangdd on 2021/10/7
 */
public class Josephus {

    private Node first;

    /**
     * 初始化约瑟夫环的大小
     *
     * @param size 约瑟夫环上节点的个数
     */
    public void initCircle(int size) {
        if (size < 1) {
            System.out.println("环的大小不能小于1");
            return;
        }
        Node currentNode = null;
        for (int i = 1; i <= size; i++) {
            Node temp = new Node(i);
            if (i == 1) {
                first = temp;
            } else {
                currentNode.next = temp;
            }
            temp.next = first;
            currentNode = temp;
        }
    }

    /**
     * 展示当前环的情况
     */
    public void showCircle() {
        if (first == null) {
            System.out.println("当前约瑟夫环还未初始化数据");
            return;
        }
        Node temp = first;
        while (true) {
            System.out.printf("当前是%d号节点\n", temp.no);
            if (temp.next == first) {
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 进行执行游戏
     * <p>
     * 从startNo开始，数到countNo的进行出圈
     *
     * @param startNo 起始的编号
     * @param countNo 计数编号
     */
    public void play(int startNo, int countNo) {
        if (first == null) {
            System.out.println("当前约瑟夫环还未初始化数据");
            return;
        }
        if (startNo <= 0 || countNo <= 0) {
            //简单校验一下
            System.out.println("当前游戏参数错误");
            return;
        }

        //初始化位置
        Node helperNode = null;
        Node temp = first;
        while (true) {
            if (temp.next == first) {
                helperNode = temp;
                break;
            }
            temp = temp.next;
        }

        //根据startNo 进行定位位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helperNode = helperNode.next;
        }

        //开始进行游戏
        while (true) {
            if (first == helperNode) {
                System.out.printf("删除最后节点%d\n", first.no);
                first = null;
                break;
            }

            Node delNode = first;

            for (int i = 0; i < countNo - 1; i++) {
                delNode = delNode.next;
                helperNode = helperNode.next;
            }
            System.out.printf("删除节点%d\n", delNode.no);
            first = delNode.next;
            helperNode.next = first;


        }
    }


    public static class Node {
        private final int no;
        private Node next;

        public Node(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
