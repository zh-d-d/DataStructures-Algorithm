package com.zhangdd.leetcode.problem.part01.problem0043;

/**
 * @author zhangdd on 2023/2/16
 *
 * <a href="https://leetcode.cn/problems/multiply-strings/">题目描述</a>
 */
public class Solution43 {


    public static void main(String[] args) {
        Solution43 solution = new Solution43();
        String result = solution.multiply("0", "0");
    }

    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int tmp = result[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j] += tmp / 10;
                result[i + j + 1] = tmp % 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        if (i >= result.length) {
            return "0";
        }
        for (; i < result.length; i++) {
            builder.append(result[i]);
        }

        return builder.toString();
    }

}
