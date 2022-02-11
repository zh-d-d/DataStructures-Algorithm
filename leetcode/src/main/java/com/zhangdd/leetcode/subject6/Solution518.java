package com.zhangdd.leetcode.subject6;

import java.util.HashMap;

public class Solution518 {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了50.27%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了28.97%的用户
     * 通过测试用例：
     * 28 / 28
     */
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 1; // base case
            for (int i = 0; i < n; i++)
                for (int j = 1; j <= amount; j++)
                    if (j - coins[i] >= 0)
                        dp[j] = dp[j] + dp[j-coins[i]];

            return dp[amount];
        }

}
