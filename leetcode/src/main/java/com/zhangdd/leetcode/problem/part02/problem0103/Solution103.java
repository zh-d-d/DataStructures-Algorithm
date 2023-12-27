package com.zhangdd.leetcode.problem.part02.problem0103;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangdd on 2023/2/7
 *
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">题目描述</a>
 *
 * <a href="https://blog.csdn.net/devnn/article/details/82716447">Java双端队列Deque使用详解</a>
 */
public class Solution103 {

    public static void main(String[] args) {
        //3,9,20,null,null,15,7
//        TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        //1,2,3,4,null,null,5
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));

        Solution103 solution = new Solution103();
        solution.zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        //true从左向右；false从右向左
        boolean flag = true;
        while (!queue.isEmpty()) {


            LinkedList<Integer> item = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (flag) {
                    item.add(node.val);
                } else {
                    item.addFirst(node.val);
                }

                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }

                size--;
            }
            result.add(item);
            flag = !flag;
        }

        return result;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}