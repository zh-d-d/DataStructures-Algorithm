package com.zhangdd.leetcode.problem0136;

/**
 * @author zhangdd on 2022/12/8
 * <a href="https://leetcode.cn/problems/single-number/">题目描述</a>
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }
}
