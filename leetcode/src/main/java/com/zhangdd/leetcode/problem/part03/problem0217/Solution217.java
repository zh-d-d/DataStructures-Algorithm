package com.zhangdd.leetcode.problem.part03.problem0217;

/**
 * @author zhangdd on 2022/12/21
 * <a href="https://leetcode.cn/problems/contains-duplicate/">题目描述</a>
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int target = nums[left];
        int i = left, j = right;
        while (i < j) {
            //每次先移动j,右指针
            while (i < j && nums[j] >= target) {
                j--;
            }
            while (i < j && nums[i] <= target) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
