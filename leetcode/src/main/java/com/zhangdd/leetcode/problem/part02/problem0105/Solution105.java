package com.zhangdd.leetcode.problem.part02.problem0105;

import java.util.Arrays;

/**
 * @author zhangdd on 2023/2/14
 *
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">题目描述</a>
 */
public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (0 == preorder.length || 0 == inorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }

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