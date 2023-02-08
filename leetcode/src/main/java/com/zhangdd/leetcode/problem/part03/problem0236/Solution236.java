package com.zhangdd.leetcode.problem.part03.problem0236;

/**
 * @author zhangdd on 2023/2/7
 *
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">题目描述</a>
 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (null != left && null != right) {
            return root;
        }

        if (null == left && null == right) {
            return null;
        } else if (null != left) {
            return left;
        } else {
            return right;
        }
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}