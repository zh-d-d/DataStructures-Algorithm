package com.zhangdd.avl;

/**
 * @author zhangdd on 2021/12/5
 */
public class AVLTree {

    private Node root;


    public void add(Node node) {
        if (null == root) {
            this.root = node;
        } else {
            this.root.add(node);
        }

        if (this.root.leftHeight() - this.root.rightHeight() > 1) {
            if (null != this.root.left &&
                    this.root.left.rightHeight() > this.root.left.leftHeight()) {
                this.root.left = this.root.left.leftRotate();

            }

            this.root = this.root.rightRotate();
        }


        if (this.root.rightHeight() - this.root.leftHeight() > 1) {


            if (null != this.root.right &&
                    this.root.right.leftHeight() > this.root.right.rightHeight()) {

                this.root.right = this.root.right.rightRotate();
            }

            this.root = this.root.leftRotate();
        }
    }

    public void infixOrder() {
        if (null == this.root) {
            System.out.println("当前树为空");
            return;
        }

        this.root.infixOrder();

    }

    public Node getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "AVLTree{" +
                "root=" + root +
                '}';
    }

    public static class Node {
        private final int value;

        private Node left;

        private Node right;


        public Node(int value) {
            this.value = value;
        }


        public void add(Node node) {
            if (this.value > node.value) {
                if (null == this.left) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else {
                if (null == this.right) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
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

        /**
         * 左旋
         * 右子树的高度 - 左子树的高度 大于1时需要进行左旋
         */
        public Node leftRotate() {
            Node newNode = new Node(right.value);

            newNode.left = this;
            newNode.right = this.right.right;

            this.right = this.right.left;

            return newNode;
        }

        /**
         * 右旋
         * 左子树的高度 - 右子树的高度 大于1时需要进行左旋
         */
        public Node rightRotate() {
            Node newNode = new Node(left.value);

            newNode.left = this.left.left;
            newNode.right = this;


            this.left = this.left.right;


            return newNode;
        }

        /**
         * 左子树高度
         */
        public int leftHeight() {
            if (null == this.left) {
                return 0;
            }
            return this.left.height();
        }

        /**
         * 右子树高度
         */
        public int rightHeight() {
            if (null == this.right) {
                return 0;
            }
            return this.right.height();
        }

        /**
         * 当前树高
         */
        public int height() {
            return Math.max(null == this.left ? 0 : this.left.height(),
                    null == this.right ? 0 : this.right.height()) + 1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
