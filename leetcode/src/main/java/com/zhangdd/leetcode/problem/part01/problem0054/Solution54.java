package com.zhangdd.leetcode.problem.part01.problem0054;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2023/2/8
 *
 * <a href="https://leetcode.cn/problems/spiral-matrix/">题目描述</a>
 */
public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = 0;
        int top = 0, down = m - 1, left = 0, right = n - 1;
        List<Integer> result = new ArrayList<>();

        while (true) {
            for (j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            if (++top > down) {
                break;
            }

            for (i = top; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }

            for (j = right; j >= left; j--) {
                result.add(matrix[down][j]);
            }
            if (--down < top) {
                break;
            }

            for (i = down; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }


        return result;
    }

}
