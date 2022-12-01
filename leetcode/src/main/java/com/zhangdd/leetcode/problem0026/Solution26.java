package com.zhangdd.leetcode.problem0026;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">题目描述</a>
 */
public class Solution26 {

    public static void main(String[] args) {
        int nums[] = {1, 1, 2};
        Solution26 solution = new Solution26();
        int index = solution.removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
