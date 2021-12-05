package com.zhangdd.binarysorttree;

/**
 * @author zhangdd on 2021/12/4
 */
public class BinarySortTree {

    private Node root;

    /**
     * 会按照从小到大的顺序，添加节点
     */
    public void add(Node node) {
        if (null == root) {
            this.root = node;
        } else {
            this.root.add(node);
        }
    }

    /**
     * 中序遍历，将按照从小到大的顺序得到排序结果
     */
    public void infixOrder() {
        if (null == root) {
            System.out.println("根节点为空");
            return;
        }
        this.root.infixOrder();
    }

    /**
     * 根据传入的值，查找对应的节点
     */
    public Node searchTargetNode(int value) {
        if (null == this.root) {
            System.out.println("根节点为空");
            return null;
        }

        return this.root.searchTargetNode(value);
    }

    /**
     * 根据传入的值，查找对应节点的父节点
     */
    public Node searchTargetParentNode(int value) {
        if (null == this.root) {
            System.out.println("根节点为空");
            return null;
        }
        if (this.root.value == value) {
            return null;
        }

        return this.root.searchTargetParentNode(value);
    }

    /**
     * 根据节点的值获取该树下最小的节点
     */
    private Node getMinNode(Node node) {
        if (null == node.left && null == node.right) {
            return node;
        }
        Node tmp = node;
        while (null != tmp.left) {
            tmp = tmp.left;
        }
        delNode(tmp.value);
        return tmp;
    }

    public void delNode(int value) {
        if (null == this.root) {
            System.out.println("当前树是空树");
            return;
        }
        Node targetNode = searchTargetNode(value);
        if (null == targetNode) {
            System.out.println("没有找到要删除的节点");
            return;
        }
        Node parentNode = searchTargetParentNode(value);


        // 要删除的节点为叶子节点
        if (null == targetNode.left && null == targetNode.right) {
            if (null == parentNode) {
                this.root = null;
            } else {
                if (null != parentNode.left && parentNode.left.value == targetNode.value) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            }
            //要删除的节点有两个子节点
        } else if (null != targetNode.left && null != targetNode.right) {
            Node minNode = getMinNode(targetNode.right);

            if (null == minNode.left) {

                minNode.left = targetNode.left;

                if (null == parentNode) {
                    this.root = minNode;
                } else {
                    if (null != parentNode.left && parentNode.left.value == targetNode.value) {
                        parentNode.left = minNode;
                    } else {
                        parentNode.right = minNode;
                    }
                }
            } else {
                minNode.left = targetNode.left;
                minNode.right = targetNode.right;

                if (null == parentNode) {
                    this.root = minNode;
                } else {

                    if (null != parentNode.left && parentNode.left.value == targetNode.value) {
                        parentNode.left = minNode;
                    } else {
                        parentNode.right = minNode;
                    }

                }
            }


            //要删除的节点只有一个子节点
        } else {
            //要删除的节点的子节点是左子节点
            if (null != targetNode.left) {
                if (null == parentNode) {
                    this.root = targetNode.left;
                } else {
                    if (null != parentNode.left && parentNode.left.value == targetNode.value) {
                        parentNode.left = targetNode.left;
                    } else {
                        parentNode.right = targetNode.left;
                    }
                }
                //要删除的节点的子节点是右子节点
            } else {
                if (null == parentNode) {
                    this.root = targetNode.right;
                } else {
                    if (null != parentNode.left && parentNode.left.value == targetNode.value) {
                        parentNode.left = targetNode.right;
                    } else {
                        parentNode.right = targetNode.right;
                    }
                }
            }
        }


    }

    @Override
    public String toString() {
        return "BinarySortTree{" +
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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
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

        public Node searchTargetNode(int value) {
            if (this.value == value) {
                return this;
            } else if (value < this.value) {
                if (null == this.left) {
                    return null;
                }
                return this.left.searchTargetNode(value);
            } else {
                if (null == this.right) {
                    return null;
                }
                return this.right.searchTargetNode(value);
            }
        }

        public Node searchTargetParentNode(int value) {
            if (this.value > value) {
                if (null != this.left) {
                    if (this.left.value == value) {
                        return this;
                    }
                    return this.left.searchTargetParentNode(value);
                }
                return null;
            } else {
                if (null != this.right) {
                    if (this.right.value == value) {
                        return this;
                    }
                    return this.right.searchTargetParentNode(value);
                }
                return null;
            }
        }


    }
}
