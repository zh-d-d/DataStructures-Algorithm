package com.zhangdd.leetcode.subject8;

public class Solution704 {
    public static void main(String[] args) {
        Solution704 solution704 = new Solution704();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(solution704.search(nums, 3));
    }

    /**
     * 47 / 47 个通过测试用例
     * 状态：通过
     * 执行用时: 0 ms
     * 内存消耗: 39.4 MB
     * 二分查找 搜素区间 前闭后闭
     */
    public int search(int[] nums, int target) {
        int left = 0, rigth = nums.length - 1;
        while (left <= rigth) {
            int mid = left + (rigth - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                rigth = mid - 1;
            }
        }
        return -1;
    }
}
