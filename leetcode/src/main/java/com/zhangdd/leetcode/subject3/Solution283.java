package com.zhangdd.leetcode.subject3;

import java.util.Arrays;

public class Solution283 {
    public static void main(String[] args) {
        Solution283 solution27 = new Solution283();
        int[] nums = new int[]{0,1,0,3,12};
        solution27.moveZeroes(nums);
    }

    /**
     * 执行用时：
     * 1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 39.6 MB, 在所有 Java 提交中击败了61.33%的用户
     * 通过测试用例：
     * 74 / 74
     */
    public void moveZeroes(int[] nums) {
        int slow = 0,fast=0;
        while (fast<nums.length){
            if (nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow<nums.length){
            nums[slow]=0;
            slow++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
