package com.zhangdd.leetcode.problem.part02.problem0171;

/**
 * @author zhangdd on 2022/12/14
 * <a href="https://leetcode.cn/problems/excel-sheet-column-number/">题目描述</a>
 */
public class Solution171 {

    public static void main(String[] args) {
        Solution171 solution = new Solution171();
        System.out.println(solution.titleToNumber("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int n = (int) c - 64;
            result = result * 26 + n;
        }
        return result;
    }

}
