package com.zhangdd.leetcode.subject2;

import java.util.Arrays;

public class Solution174 {
    public static void main(String[] args) {
        Solution174 solution174 = new Solution174();

    }

    /**
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 41 MB, 在所有 Java 提交中击败了6.16%的用户
     * 通过测试用例：
     * 45 / 45
     */
    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 备忘录中都初始化为 -1
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(grid, 0, 0);
    }
    // 备忘录，消除重叠⼦问题
    int[][] memo;
    /* 定义：从 (i, j) 到达右下⻆，需要的初始⾎量⾄少是多少 */
    int dp(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        // base case
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        // 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 状态转移逻辑
        int res = Math.min(
                dp(grid, i, j + 1),
                dp(grid, i + 1, j)
        ) - grid[i][j];
        // 骑⼠的⽣命值⾄少为 1
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }
}
