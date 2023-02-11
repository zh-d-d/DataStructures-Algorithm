package com.zhangdd.leetcode.problem.part01.problem0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangdd on 2023/2/11
 *
 * <a href="https://leetcode.cn/problems/merge-intervals/">题目描述</a>
 */
public class Solution56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution56 solution = new Solution56();
        int[][] result = solution.merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        quickSort(intervals, 0, intervals.length - 1);

        List<int[]> result = new ArrayList<>(Arrays.asList(intervals));
        int i = 0;
        int j = 1;
        while (j < result.size()) {
            int[] num1 = result.get(i);
            int[] num2 = result.get(j);


            if (num1[1] >= num2[0]) {
                int value = Math.max(num1[1], num2[1]);
                num1[1] = value;

                result.remove(j);
            } else {
                i++;
                j++;
            }
        }
        return result.toArray(new int[0][0]);
    }

    private void quickSort(int[][] intervals, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] target = new int[2];
        target[0] = intervals[left][0];
        target[1] = intervals[left][1];

        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && target[0] <= intervals[j][0]) {
                j--;
            }
            while (i < j && target[0] >= intervals[i][0]) {
                i++;
            }
            swap(intervals, i, j);
        }
        swap(intervals, left, i);
        quickSort(intervals, left, i - 1);
        quickSort(intervals, i + 1, right);
    }

    private void swap(int[][] intervals, int i, int j) {
        int[] tmp = new int[2];
        tmp[0] = intervals[i][0];
        tmp[1] = intervals[i][1];

        intervals[i][0] = intervals[j][0];
        intervals[i][1] = intervals[j][1];

        intervals[j][0] = tmp[0];
        intervals[j][1] = tmp[1];
    }


}
