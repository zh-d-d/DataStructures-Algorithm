package com.zhangdd.huffmantree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangdd on 2021/11/28
 */
public class HuffmanTree {


    public Node buildHuffmanTree(int[] arr) {
        List<Node> nodes = Arrays.stream(arr).mapToObj(Node::new)
                .collect(Collectors.toList());

        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            Node leftNode = nodes.remove(0);
            Node rightNode = nodes.remove(0);

            Node parent = new Node(leftNode.value + rightNode.value);
            nodes.add(parent);
            parent.left = leftNode;
            parent.right = rightNode;

            Collections.sort(nodes);
        }


        return nodes.get(0);
    }


    public void priOrder(Node node) {
        if (null == node) {
            System.out.println("当前树为空");
            return;
        }
        node.preOrder();
    }


    public static class Node implements Comparable<Node> {
        private final int value;

        private Node left;

        private Node right;

        public Node(int value) {
            this.value = value;
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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            //如果是从小到大排序则使用 this.value - o.value
            //如果是从大到校排序则使用 o.value - this.value
            return this.value - o.value;
        }
    }
}
