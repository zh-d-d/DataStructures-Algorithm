package com.zhangdd.leetcode.problem.part01.problem0041;

/**
 * @author zhangdd on 2023/2/14
 *
 * <a href="https://leetcode.cn/problems/first-missing-positive/">题目描述</a>
 */
public class Solution41 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0};
        Solution41 solution = new Solution41();
        int result = solution.firstMissingPositive(nums);
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean[] mark = new boolean[len + 1];

        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                continue;
            }
            mark[nums[i] - 1] = true;
        }

        for (int i = 0; i < mark.length; i++) {
            if (!mark[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}
