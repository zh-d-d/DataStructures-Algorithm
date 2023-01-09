package com.zhangdd.leetcode.problem.part03.problem0283;

/**
 * @author zhangdd on 2023/1/9
 *
 * <a href="https://leetcode.cn/problems/move-zeroes/">题目描述</a>
 */
public class Solution283 {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
    }

}
