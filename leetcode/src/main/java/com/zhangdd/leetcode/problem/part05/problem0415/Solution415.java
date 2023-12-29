package com.zhangdd.leetcode.problem.part05.problem0415;

/**
 * @author zhangdd on 2023/2/10
 *
 * <a href="https://leetcode.cn/problems/add-strings/">题目描述</a>
 */
public class Solution415 {

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        int maxLength = Math.max(m, n);
        int flag = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            m--;
            n--;

            int n1;
            if (m >= 0) {
                n1 = num1.charAt(m) - '0';
            } else {
                n1 = 0;
            }

            int n2;
            if (n >= 0) {
                n2 = num2.charAt(n) - '0';
            } else {
                n2 = 0;
            }
            int sum = n1 + n2 + flag;
            builder.append(sum % 10);

            if (sum / 10 > 0) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
        if (flag > 0) {
            builder.append(flag);
        }


        return builder.reverse().toString();
    }
}
