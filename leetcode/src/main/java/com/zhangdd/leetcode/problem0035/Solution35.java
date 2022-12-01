package com.zhangdd.leetcode.problem0035;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/search-insert-position/">题目描述</a>
 */
public class Solution35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        Solution35 solution = new Solution35();
        System.out.println(solution.searchInsert(nums, 4));
    }


    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length;
        int middleIndex = 0;
        while (left < right) {
            middleIndex = (left + right) / 2;
            if (nums[middleIndex] == target) {
                return middleIndex;
            } else if (target < nums[middleIndex]) {
                right = middleIndex;
            } else {
                left = middleIndex + 1;
            }
        }
        return left;
    }

}
