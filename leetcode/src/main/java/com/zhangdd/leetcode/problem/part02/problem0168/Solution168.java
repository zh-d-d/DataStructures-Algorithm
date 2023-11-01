package com.zhangdd.leetcode.problem.part02.problem0168;

/**
 * @author zhangdd on 2022/12/13
 *
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">题目描述</a>
 */
public class Solution168 {

    public static void main(String[] args) {
        Solution168 solution = new Solution168();
        int columnNumber = 28;
        System.out.println(solution.convertToTitle(columnNumber));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber >= 1) {
            int i = (columnNumber - 1) % 26;
            columnNumber = (columnNumber - 1) / 26;

            builder.append(Character.toString(65 + i));
        }

        return builder.reverse().toString();
    }

}
