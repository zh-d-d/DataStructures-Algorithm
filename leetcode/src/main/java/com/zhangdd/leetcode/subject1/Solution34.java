package com.zhangdd.leetcode.subject1;

public class Solution34 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(solution34.searchRange(nums, 8));
    }

    /**
     * 88 / 88 个通过测试用例
     * 状态：通过
     * 执行用时: 0 ms
     * 内存消耗: 41.7 MB
     * 最左侧边界二分查找 搜素区间 前闭后闭
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0, rigth = nums.length - 1;
        while (left <= rigth) {
            int mid = left + (rigth - left) / 2;
            if (nums[mid] > target) {
                rigth = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                rigth = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return res;
        }
        res[0] = left;
        while (left < nums.length && nums[left] == target) {
            res[1] = left;
            left++;
        }
        return res;
    }
}
