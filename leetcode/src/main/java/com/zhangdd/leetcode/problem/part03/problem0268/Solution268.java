package com.zhangdd.leetcode.problem.part03.problem0268;

/**
 * @author zhangdd on 2023/1/6
 *
 * <a href="https://leetcode.cn/problems/missing-number/">题目描述</a>
 */
public class Solution268 {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }
}
