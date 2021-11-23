package com.zhangdd.tree;

/**
 * @author zhangdd on 2021/11/23
 */
public class ThreadedBinaryTreeExample {

    public static void main(String[] args) {

        ThreadedBinaryTree.Node root=new ThreadedBinaryTree.Node(1,"mick");
        ThreadedBinaryTree.Node node1=new ThreadedBinaryTree.Node(3,"jack");
        ThreadedBinaryTree.Node node2=new ThreadedBinaryTree.Node(6,"tom");
        ThreadedBinaryTree.Node node3=new ThreadedBinaryTree.Node(8,"smith");
        ThreadedBinaryTree.Node node4=new ThreadedBinaryTree.Node(10,"marry");
        ThreadedBinaryTree.Node node5=new ThreadedBinaryTree.Node(14,"king");

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);

        ThreadedBinaryTree tree=new ThreadedBinaryTree(root);

        tree.infixThreaded();

        System.out.println("10号节点的前驱节点是"+node4.getLeft());
        System.out.println("10号节点的后继节点是"+node4.getRight());

    }

}
