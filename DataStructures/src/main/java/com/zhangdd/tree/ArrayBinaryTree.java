package com.zhangdd.tree;

/**
 * @author zhangdd on 2021/11/18
 */
public class ArrayBinaryTree {
    private final int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        preOrder(0);
    }

    public void infixOrder() {
        infixOrder(0);
    }

    public void postOrder() {
        postOrder(0);
    }

    private void preOrder(int index) {
        if (index > arr.length - 1) {
            return;
        }
        System.out.println(arr[index]);
        //向做遍历
        preOrder(2 * index + 1);

        //向右遍历
        preOrder(2 * index + 2);

    }

    private void infixOrder(int index) {
        if (index > arr.length - 1) {
            return;
        }
        //向左遍历
        infixOrder(2 * index + 1);
        //当前节点
        System.out.println(arr[index]);
        //向右遍历
        infixOrder(2 * index + 2);
    }

    private void postOrder(int index) {
        if (index > arr.length - 1) {
            return;
        }
        //向左遍历
        postOrder(2 * index + 1);

        //向右遍历
        postOrder(2 * index + 2);

        //当前节点
        System.out.println(arr[index]);
    }
}
