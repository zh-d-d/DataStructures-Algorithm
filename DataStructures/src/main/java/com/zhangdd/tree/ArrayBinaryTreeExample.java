package com.zhangdd.tree;

/**
 * @author zhangdd on 2021/11/18
 */
public class ArrayBinaryTreeExample {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);

//        tree.preOrder();

//        tree.infixOrder();

        tree.postOrder();
    }
}
