package com.zhangdd.leetcode.problem.part02.problem0108;

import java.util.Arrays;

/**
 * @author zhangdd on 2022/12/7
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/">题目描述</a>
 */
public class Solution108 {

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        Solution108 solution = new Solution108();
        TreeNode treeNode = solution.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int middle = nums.length / 2;
        TreeNode node = new TreeNode(nums[middle]);

        int[] leftNums = Arrays.copyOfRange(nums, 0, middle);

        int[] rightNums = Arrays.copyOfRange(nums, middle + 1, nums.length);


        if (leftNums.length > 0) {
            node.left = sortedArrayToBST(leftNums);
        }

        if (rightNums.length > 0) {
            node.right = sortedArrayToBST(rightNums);
        }

        return node;
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}