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
            node.leftType = 1;
        }
        //处理上一个节点 的后继节点
        if (null != pre && null == pre.right) {
            pre.right = node;
            pre.rightType = 1;
        }
        //这里就是标识前驱节点
        pre = node;


        //处理右节点
        infixThreaded(node.right);

    }

    /**
     * 中序遍历线索化二叉树
     */
    public void infixListThreadedTree() {
        infixListThreadedTree(root);
    }

    /**
     * 中序遍历线索化二叉树
     * 首先中序遍历的基本思想是先左节点，在当前节点，在右节点
     * <p>
     * 1.从当前节点开始，判断当前节点的左节点是否是前驱节点类型，如果是，那么当前节点就是第一个节点，且当前节点的左节点还为null
     * 2.输出当前节点
     * 3.判断当前节点的右节点类型是否是后继节点，如果是则可以一直输出（因为在实现线索化时，）
     */
    private void infixListThreadedTree(Node node) {

        if (null == node) {
            return;
        }
        Node temp = node;

        while (null != temp) {

            while (1 != temp.leftType) {
                temp = temp.left;
            }
            System.out.println(temp);


            while (1 == temp.rightType) {
                temp = temp.right;
                System.out.println(temp);
            }

            temp = temp.right;
        }

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
