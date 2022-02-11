package com.zhangdd.leetcode.subject5;

import java.util.Arrays;

public class Solution416 {
    int[][] memo;

    /**
     执行用时：16 ms, 在所有 Java 提交中击败了93.79%的用户
     内存消耗：39.7 MB, 在所有 Java 提交中击败了20.13%的用户
     通过测试用例：117 / 117
     */
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return false;
            }
            int sum = 0, maxNum = 0;
            for (int num : nums) {
                sum += num;
                maxNum = Math.max(maxNum, num);
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (maxNum > target) {
                return false;
            }
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                for (int j = target; j >= num; --j) {
                    dp[j] |= dp[j - num];
                }
            }
            return dp[target];
        }
}
