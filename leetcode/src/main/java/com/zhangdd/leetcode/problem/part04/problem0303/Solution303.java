package com.zhangdd.leetcode.problem.part04.problem0303;

/**
 * @author zhangdd on 2023/1/14
 *
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/">题目描述</a>
 */
public class Solution303 {

    class NumArray {

        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            if (nums.length == 0) {
                return;
            }
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] += sums[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sums[j];
            } else {
                return sums[j] - sums[i - 1];
            }
        }
    }
}
