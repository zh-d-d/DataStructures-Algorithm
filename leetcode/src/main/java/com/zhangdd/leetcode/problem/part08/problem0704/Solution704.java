package com.zhangdd.leetcode.problem.part08.problem0704;

/**
 * @author zhangdd on 2023/2/10
 *
 * <a href="https://leetcode.cn/problems/binary-search/">题目描述</a>
 */
public class Solution704 {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return binarySearch(nums, target, left, middle - 1);
        } else {
            return binarySearch(nums, target, middle + 1, right);
        }
    }
}
