package com.zhangdd.tree;

/**
 * @author zhangdd on 2021/11/11
 */
public class BinaryTreeExample {

    public static void main(String[] args) {

        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1, "宋江");
        BinaryTree.TreeNode node2 = new BinaryTree.TreeNode(2, "吴用");
        BinaryTree.TreeNode node3 = new BinaryTree.TreeNode(3, "卢俊义");
        BinaryTree.TreeNode node4 = new BinaryTree.TreeNode(4, "林冲");
        BinaryTree.TreeNode node5 = new BinaryTree.TreeNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);

        node3.setLeft(node5);
        node3.setRight(node4);

        BinaryTree tree = new BinaryTree(root);

        System.out.println("前序");
        tree.preOrder();
        System.out.println("中序");
        tree.infixOrder();
        System.out.println("后序");
        tree.postOrder();
    }
}
