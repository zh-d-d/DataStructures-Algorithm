package com.zhangdd.leetcode.subject1;

import java.util.Arrays;

public class Solution26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution26.removeDuplicates(nums));
    }

    /**
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 39.8 MB, 在所有 Java 提交中击败了55.94%的用户
     * 通过测试用例：
     * 362 / 362
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0,fast=0;
        while (fast<nums.length){
            if (nums[fast]!=nums[slow]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
        return slow+1;
    }
}
