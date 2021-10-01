package com.zhangdd.linkedlist;

import org.junit.Before;
import org.junit.Test;

/**
 * @author zhangdd on 2021/10/1
 */
public class DoubleLinkedExample {

    private DoubleLinkedList linkedList = new DoubleLinkedList();

    @Before
    public void init() {
        DoubleLinkedList.Node node1 = new DoubleLinkedList.Node(1, "曹操", "曹孟德");
        DoubleLinkedList.Node node2 = new DoubleLinkedList.Node(2, "刘备", "刘玄德");
        DoubleLinkedList.Node node3 = new DoubleLinkedList.Node(3, "吕布", "吕奉先");
        DoubleLinkedList.Node node4 = new DoubleLinkedList.Node(4, "周瑜", "周公瑾");


        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);

    }


    @Test
    public void doubleLinkedAddTest() {

        linkedList.list();

    }

    @Test
    public void doubleLinkedUpdateTest() {
        DoubleLinkedList.Node node4 = new DoubleLinkedList.Node(4, "周瑜", "小周");
        linkedList.update(node4);
        linkedList.list();
    }

    @Test
    public void doubleLinkedDel() {
        linkedList.del(2);
        linkedList.list();
    }

    @Test
    public void doubleLinkedAddByOrder() {
        DoubleLinkedList.Node node1 = new DoubleLinkedList.Node(1, "曹操", "曹孟德");
        DoubleLinkedList.Node node4 = new DoubleLinkedList.Node(4, "周瑜", "周公瑾");
        DoubleLinkedList.Node node2 = new DoubleLinkedList.Node(2, "刘备", "刘玄德");
        DoubleLinkedList.Node node3 = new DoubleLinkedList.Node(3, "吕布", "吕奉先");

        DoubleLinkedList linkedList2 = new DoubleLinkedList();
        linkedList2.addByOrder(node1);
        linkedList2.addByOrder(node4);
        linkedList2.addByOrder(node2);
        linkedList2.addByOrder(node3);

        linkedList2.list();
    }
}
