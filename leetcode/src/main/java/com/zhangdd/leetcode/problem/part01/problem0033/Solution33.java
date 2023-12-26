package com.zhangdd.leetcode.problem.part01.problem0033;

/**
 * @author zhangdd on 2023/2/6
 *
 * <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">题目描述</a>
 */
public class Solution33 {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        //匹配是否有target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
