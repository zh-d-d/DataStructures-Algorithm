package com.zhangdd.leetcode.problem.part02.problem0145;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2022/12/8
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">题目描述</a>
 */
public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
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