package com.zhangdd.leetcode.problem.part02.problem0169;

/**
 * @author zhangdd on 2022/12/13
 *
 * <a href="https://leetcode.cn/problems/majority-element/description/">题目描述</a>
 */
public class Solution169 {

    public static void main(String[] args) {
        Solution169 solution = new Solution169();
        int[] nums = new int[]{1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6, 2, 2};
        System.out.println(solution.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count <= 0) {
                num = nums[i];
                count++;
            }
        }
        return num;
    }
}
