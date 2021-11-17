package com.zhangdd.tree;

/**
 * @author zhangdd on 2021/11/16
 */
public class BinaryTreeDelExample {

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

        System.out.println("遍历结果");
        tree.preOrder();

        tree.remove(2);

        System.out.println("删除节点后遍历结果");
        tree.preOrder();

    }
}
