package com.zhangdd.tree;

/**
 * @author zhangdd on 2021/11/23
 */
public class ThreadedBinaryTree {

    private Node root;

    //由于树是单向的，所以在遍历时需要标识下当前节点的前驱节点
    private Node pre;

    public ThreadedBinaryTree(Node root) {
        this.root = root;
    }

    public void infixThreaded() {
        infixThreaded(root);
    }

    /**
     * 中序线索化
     *
     * @param node 对二叉树进行线索化其实就是对二叉树的节点进行线索化
     */
    public void infixThreaded(Node node) {
        if (null == node) {
            return;
        }
        //处理左节点
        infixThreaded(node.left);

        //处理当前节点 的前驱节点
        if (null == node.left) {
            node.left = pre;
            node.leftType = 0;
        }
        //处理当前节点 的后继节点
        if (null != pre && null == pre.right) {
            pre.right = node;
            pre.rightType = 1;
        }
        //这里就是标识前驱节点
        pre = node;


        //处理右节点
        infixThreaded(node.right);

    }

    public static class Node {
        private final int no;
        private final String name;

        private Node left;
        private Node right;

        //子节点类型，如果为0代表子节点是左子树，如果为1代表前驱节点
        private int leftType;
        //子节点类型，如果为0代表子节点是右子树，如果为1代表前后继节点
        private int rightType;


        public Node(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
