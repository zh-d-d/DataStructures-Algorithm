package com.zhangdd.leetcode.subject9;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution877 {
    public static void main(String[] args) {
        Solution877 solution877 = new Solution877();
        int[] arr = new int[]{2,8,3,5};
        System.out.println(solution877.stoneGame(arr));
    }

    /**
     执行用时：13 ms, 在所有 Java 提交中击败了7.82%的用户
     内存消耗：49.2 MB, 在所有 Java 提交中击败了5.96%的用户
     通过测试用例：
     46 / 46
     */
    /* 返回游戏最后先⼿和后⼿的得分之差 */
    public int stoneGame(int[] piles) {
        int n = piles.length;
        // 初始化 dp 数组
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                dp[i][j] = new Pair(0, 0);
        // 填⼊ base case
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }
        // 倒着遍历数组
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 先⼿选择最左边或最右边的分数
                int left = piles[i] + dp[i+1][j].sec;
                int right = piles[j] + dp[i][j-1].sec;
                // 套⽤状态转移⽅程
                // 先⼿肯定会选择更⼤的结果，后⼿的选择随之改变
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }
        Pair res = dp[0][n-1];
        return res.fir - res.sec;
    }
}

class Pair {
    int fir, sec;
    Pair(int fir, int sec) {
        this.fir = fir;
        this.sec = sec;
    }
}