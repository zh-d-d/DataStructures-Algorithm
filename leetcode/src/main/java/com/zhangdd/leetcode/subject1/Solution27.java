package com.zhangdd.leetcode.subject1;

import java.util.Arrays;

public class Solution27 {
    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(solution27.removeDuplicates(nums,2));
    }

    /**
     * 执行用时：
     * 2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 37.1 MB, 在所有 Java 提交中击败了17.45%的用户
     * 通过测试用例：
     * 113 / 113
     */
    public int removeDuplicates(int[] nums,int val) {
        int slow = 0,fast=0;
        while (fast<nums.length){
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
        return slow;
    }
}
