package com.zhangdd.leetcode.problem0094;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">题目描述</a>
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        inorderTraversal(root, result);

        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            inorderTraversal(root.left, result);
        }
        result.add(root.val);
        if (null != root.right) {
            inorderTraversal(root.right, result);
        }
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

