package com.zhangdd.leetcode.problem.part02.problem0124;

/**
 * @author zhangdd on 2023/2/10
 *
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/">题目描述</a>
 */
public class Solution124 {

    public static void main(String[] args) {
        Solution124 solution = new Solution124();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int value = solution.maxPathSum(root);
        System.out.println(value);
    }

    private int maxValue = -1000;

    public int maxPathSum(TreeNode root) {
        process(root);
        return maxValue;
    }

    private int process(TreeNode root) {
        if (null == root) {
            return -1000;
        }
        int value = root.val;
        int leftValue = process(root.left);
        int rightValue = process(root.right);
        int sum = leftValue + value + rightValue;

        int maxValue1 = Math.max(leftValue, Math.max(rightValue, sum));

        int maxValue2 = Math.max(leftValue + value, Math.max(value, rightValue + value));

        //记录 过程中 当前节点 下 可以产生的最大值
        this.maxValue = Math.max(maxValue, Math.max(maxValue1, maxValue2));

        //返回当前节点作为可以向上叠加时（根，根+左，根+右）的最大值
        return maxValue2;
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