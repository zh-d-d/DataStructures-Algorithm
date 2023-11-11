package com.zhangdd.leetcode.problem.part03.problem0226;

/**
 * @author zhangdd on 2022/12/24
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">题目描述</a>
 */
public class Solution226 {

    // 先序遍历--从顶向下交换
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 保存右子树
        TreeNode rightTree = root.right;
        // 交换左右子树的位置
        root.right = invertTree(root.left);
        root.left = invertTree(rightTree);
        return root;
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
