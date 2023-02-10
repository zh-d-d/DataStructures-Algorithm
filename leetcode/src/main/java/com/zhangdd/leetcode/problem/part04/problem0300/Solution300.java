package com.zhangdd.leetcode.problem.part04.problem0300;

import java.util.Arrays;

/**
 * @author zhangdd on 2023/2/10
 *
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">题目描述</a>
 */
public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        //dp数组 用来存放最大长度 即dp[i] 表示 nums数组在0-i这个范围内 最大的递增数组长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        //完善dp数组的值
        //两层for循环
        //第一层循环 ，用来遍历得到第 i 个元素
        //第二层循环， 从头开始 比较 比 第i个小的元素有几个
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        //遍历dp数组找到最大的值
        int result = 1;
        for (int num : dp) {
            result = Math.max(result, num);
        }
        return result;
    }
}
