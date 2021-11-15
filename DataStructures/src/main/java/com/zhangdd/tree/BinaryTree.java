package com.zhangdd.tree;

/**
 * @author zhangdd on 2021/11/11
 */
public class BinaryTree {

    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (null == root) {
            System.out.println("当前树空");
            return;
        }
        root.preOrder();
    }

    public void infixOrder() {
        if (null == root) {
            System.out.println("当前树空");
            return;
        }
        root.infixOrder();
    }

    public void postOrder() {
        if (null == root) {
            System.out.println("当前树空");
            return;
        }
        root.postOrder();
    }


    public static class TreeNode {
        private int no;
        private String name;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public void preOrder() {
            System.out.println(this);
            if (null != this.left) {
                this.left.preOrder();
            }
            if (null != this.right) {
                this.right.preOrder();
            }
        }

        public void infixOrder() {
            if (null != this.left) {
                this.left.infixOrder();
            }
            System.out.println(this);
            if (null != this.right) {
                this.right.infixOrder();
            }
        }

        public void postOrder() {
            if (null != this.left) {
                this.left.postOrder();
            }
            if (null != this.right) {
                this.right.postOrder();
            }
            System.out.println(this);
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
