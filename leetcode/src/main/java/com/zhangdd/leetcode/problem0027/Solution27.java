package com.zhangdd.leetcode.problem0027;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/remove-element/">题目描述</a>
 */
public class Solution27 {


    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
