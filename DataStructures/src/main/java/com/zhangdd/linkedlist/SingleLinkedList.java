package com.zhangdd.linkedlist;

/**
 * @author zhangdd on 2021/9/26
 */
public class SingleLinkedList {

    //初始化头节点，仅仅用作链表的标识头，不做有效数据
    private Node head = new Node(0, null, null);

    public Node getHead() {
        return head;
    }

    /**
     * 添加节点时，找到当前链表的最后一个节点，进行设置
     *
     * @param node 待添加的节点
     */
    public void add(Node node) {
        Node temp = head;
        while (true) {
            //当temp.next为空时，此时temp指向链表的最后一个节点
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 按顺序添加节点，如果节点序号存在则不重复添加
     *
     * @param node 待添加的节点
     */
    public void addByOrder(Node node) {
        Node temp = head;
        boolean dumpValue = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                dumpValue = true;
                break;
            }
            temp = temp.next;
        }
        if (dumpValue) {
            System.out.printf("添加的节点的值[%d]已经存在%s", node.no, temp.next);
            return;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void update(Node node) {
        Node temp = head;
        boolean endNode = false;
        while (true) {
            if (temp.next == null) {
                endNode = true;
                break;
            }
            if (temp.next.no == node.no) {
                break;
            }
            temp = temp.next;
        }
        if (endNode) {
            System.out.println("要更新的节点不存在");
            return;
        }
        node.next = temp.next.next;
        temp.next = node;
    }

    /**
     * 将链表反转
     *
     * @param headNode 链表的头节点
     */
    public void revertList(Node headNode) {
        if (headNode.next == null || headNode.next.next == null) {
            return;
        }
        Node newHead = new Node(0, null, null);
        Node curNode = headNode.next;
        Node nextNode;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = newHead.next;
            newHead.next = curNode;
            curNode = nextNode;
        }
        headNode.next = newHead.next;
    }


    public void del(int no) {
        Node temp = head;
        boolean endNode = false;
        while (true) {
            if (temp.next == null) {
                endNode = true;
                break;
            }
            if (temp.next.no == no) {
                break;
            }
            temp = temp.next;
        }
        if (endNode) {
            System.out.println("链表中不存在要删除的节点");
            return;
        }
        temp.next = temp.next.next;
    }


    /**
     * 遍历链表，获取头节点下一个节点这是有效数据节点，打印，判断有效节点的下一个节点是否结束 遍历
     */
    public void list() {
        if (head.next == null) {
            System.out.println("当前链表为空");
            return;
        }
        Node temp = head.next;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }


    public static class Node {
        private int no;
        private String name;
        private String nickname;
        private Node next;

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
