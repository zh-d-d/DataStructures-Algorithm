package com.zhangdd.leetcode.problem.part02.problem0104;

/**
 * @author zhangdd on 2022/12/7
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">题目描述</a>
 */
public class Solution104 {


    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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

