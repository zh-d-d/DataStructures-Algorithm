package com.zhangdd.leetcode.problem.part01.problem0053;

/**
 * @author zhangdd on 2023/2/3
 *
 * <a href="https://leetcode.cn/problems/length-of-last-word/">题目描述</a>
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tmpSum = 0;

        for (int num : nums) {
            if (num + tmpSum > num) {
                tmpSum += num;
            } else {
                tmpSum = num;
            }
            maxSum = Math.max(maxSum, tmpSum);
        }

        return maxSum;
    }
}
