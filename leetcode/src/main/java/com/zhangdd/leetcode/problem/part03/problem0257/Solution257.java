package com.zhangdd.leetcode.problem.part03.problem0257;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2022/12/31
 * <a href="https://leetcode.cn/problems/binary-tree-paths/description/">题目描述</a>
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        String current_path = Integer.toString(root.val);
        if (root.left == null && root.right == null) result.add(current_path);
        if (root.left != null) dfs(root.left, current_path, result);
        if (root.right != null) dfs(root.right, current_path, result);
        return result;
    }

    public void dfs(TreeNode node, String current_path, List<String> result) {
        current_path += "->" + node.val;
        if (node.left == null && node.right == null) {
            result.add(current_path);
        }
        if (node.left != null) dfs(node.left, current_path, result);
        if (node.right != null) dfs(node.right, current_path, result);
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