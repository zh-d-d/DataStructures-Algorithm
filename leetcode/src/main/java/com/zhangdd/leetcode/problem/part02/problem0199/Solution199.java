package com.zhangdd.leetcode.problem.part02.problem0199;

import java.util.*;

/**
 * @author zhangdd on 2023/2/11
 *
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/">题目描述</a>
 */
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (queue.size() > 0) {
            int size = queue.size();


            while (size > 0) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }


                if (size == 1) {
                    result.add(node.val);
                }
                size--;
            }
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