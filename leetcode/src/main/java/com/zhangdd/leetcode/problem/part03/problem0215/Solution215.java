package com.zhangdd.leetcode.problem.part03.problem0215;

/**
 * @author zhangdd on 2023/2/2
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {

        quickSort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    /**
     * 快排
     */
    private void quickSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        //取一个元素，作为待比较元素
        int target = nums[left];
        int i = left, j = right;

        //寻找target 的目标位置 i ，
        while (i < j) {
            //从右向左，直到 遇到比 target小的元素，或者目标位置
            while (i < j && nums[j] >= target) {
                j--;
            }

            //从左向右，直到 遇到 大于target的元素，或者目标位置
            while (i < j && nums[i] <= target) {
                i++;
            }
            swap(nums, i, j);
        }

        //这个时候 i是当前target的目标位置，将target 放到目标位置，这个时候 target左边的都比target小，右边的都比target大
        swap(nums, i, left);
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    /**
     * 交换 i , j 元素
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
