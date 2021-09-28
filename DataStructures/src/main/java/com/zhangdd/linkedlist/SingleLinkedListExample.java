package com.zhangdd.linkedlist;

import org.junit.Test;

/**
 * @author zhangdd on 2021/9/26
 */
public class SingleLinkedListExample {


    @Test
    public void simpleListAddTest() {
        SingleLinkedList.Node node1 = new SingleLinkedList.Node(1, "曹操", "曹孟德");
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2, "刘备", "刘玄德");
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3, "吕布", "吕奉先");
        SingleLinkedList.Node node4 = new SingleLinkedList.Node(4, "周瑜", "周公瑾");

        SingleLinkedList linkedList = new SingleLinkedList();
        //普通添加
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node4);
        linkedList.add(node3);

        linkedList.list();
    }

    @Test
    public void orderListAddTest() {
        SingleLinkedList.Node node1 = new SingleLinkedList.Node(1, "曹操", "曹孟德");
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2, "刘备", "刘玄德");
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3, "吕布", "吕奉先");
        SingleLinkedList.Node node4 = new SingleLinkedList.Node(4, "周瑜", "周公瑾");

        SingleLinkedList linkedList = new SingleLinkedList();

        //按编号顺序添加
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);

        //删除节点
        linkedList.del(1);

        linkedList.list();
    }

    @Test
    public void updateListTest() {
        SingleLinkedList.Node node1 = new SingleLinkedList.Node(1, "曹操", "曹孟德");
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2, "刘备", "刘玄德");
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3, "吕布", "吕奉先");
        SingleLinkedList.Node node4 = new SingleLinkedList.Node(4, "周瑜", "周公瑾");

        SingleLinkedList linkedList = new SingleLinkedList();


        //按编号顺序添加
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);

        linkedList.update(new SingleLinkedList.Node(2, "刘备", "小刘"));

        linkedList.list();
    }


    @Test
    public void revertListTest() {
        SingleLinkedList.Node node1 = new SingleLinkedList.Node(1, "曹操", "曹孟德");
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2, "刘备", "刘玄德");
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3, "吕布", "吕奉先");
        SingleLinkedList.Node node4 = new SingleLinkedList.Node(4, "周瑜", "周公瑾");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node4);
        linkedList.add(node3);
        System.out.println("反转之前链表状态");
        linkedList.list();

        System.out.println("将链表进行反转");
        linkedList.revertList(linkedList.getHead());
        linkedList.list();

    }

    @Test
    public void linkListLengthTest() {
        SingleLinkedList.Node node1 = new SingleLinkedList.Node(1, "曹操", "曹孟德");
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2, "刘备", "刘玄德");
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3, "吕布", "吕奉先");
        SingleLinkedList.Node node4 = new SingleLinkedList.Node(4, "周瑜", "周公瑾");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node4);
        linkedList.add(node3);

        System.out.println(linkedList.getLength(linkedList.getHead()));
    }

    @Test
    public void findLastIndexNodeTest() {
        SingleLinkedList.Node node1 = new SingleLinkedList.Node(1, "曹操", "曹孟德");
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2, "刘备", "刘玄德");
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3, "吕布", "吕奉先");
        SingleLinkedList.Node node4 = new SingleLinkedList.Node(4, "周瑜", "周公瑾");

        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);

        System.out.println(linkedList.findLastIndexNode(linkedList.getHead(), 4));
    }

    @Test
    public void mergeOrderLinkListTest() {
        SingleLinkedList.Node node1 = new SingleLinkedList.Node(1, "曹操", "曹孟德");
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2, "刘备", "刘玄德");
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3, "吕布", "吕奉先");
        SingleLinkedList.Node node4 = new SingleLinkedList.Node(4, "周瑜", "周公瑾");

        SingleLinkedList linkedList1 = new SingleLinkedList();
        linkedList1.addByOrder(node1);
        linkedList1.addByOrder(node3);

        SingleLinkedList linkedList2 = new SingleLinkedList();
        linkedList2.addByOrder(node2);
        linkedList2.addByOrder(node4);

        SingleLinkedList linkedList = linkedList1
                .mergeOrderLinkList(linkedList2.getHead());
        linkedList.list();

    }
}
