package com.zhangdd.leetcode.subject2;

import com.zhangdd.leetcode.subjectunknow.TreeNode;

import javax.swing.tree.TreeCellRenderer;

public class Solution104 {
    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        System.out.println();
    }

    /**
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 38.5 MB , 在所有 Java 提交中击败了 5.23%的用户
     * 通过测试用例：
     * 39 / 39
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        int res = Math.max(leftMax, rightMax) + 1;
        return res;
    }


    /**
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 38.3 MB , 在所有 Java 提交中击败了 43.31%的用户
     * 通过测试用例：
     * 39 / 39
     */
    int res=0;
    int depth=0;

    public int maxDepthH(TreeNode root){
        traverse(root);
        return  res;
    }
    public void traverse(TreeNode root){
        if (root==null){
            res=Math.max(res,depth);
            return;
        }
        depth++;
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}


