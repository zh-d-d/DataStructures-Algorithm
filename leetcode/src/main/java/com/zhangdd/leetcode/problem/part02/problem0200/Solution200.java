package com.zhangdd.leetcode.problem.part02.problem0200;

/**
 * @author zhangdd on 2023/2/7
 *
 * <a href="https://leetcode.cn/problems/number-of-islands/discussion/">题目描述</a>
 */
public class Solution200 {

    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    growth(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void growth(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 2;
        growth(grid, i, j + 1);
        growth(grid, i + 1, j);
        growth(grid, i, j - 1);
        growth(grid, i - 1, j);
    }
}
