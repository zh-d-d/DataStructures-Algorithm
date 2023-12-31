package com.zhangdd.leetcode.problem.part01.problem0070;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">题目描述</a>
 */
public class Solution70 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
