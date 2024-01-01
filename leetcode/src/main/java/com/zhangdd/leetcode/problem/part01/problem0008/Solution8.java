package com.zhangdd.leetcode.problem.part01.problem0008;

/**
 * @author zhangdd on 2023/2/12
 *
 * <a href="https://leetcode.cn/problems/string-to-integer-atoi/">题目描述</a>
 */
public class Solution8 {

    public static void main(String[] args) {
        Solution8 solution = new Solution8();
        int result = solution.myAtoi("  0000000000012345678");
    }

    public int myAtoi(String s) {
        if (null == s || s.trim().length() == 0) {
            return 0;
        }
        s = s.trim();

        //是否为负数
        boolean negativeNum = false;
        //是否应该跳跃这个0
        boolean skipZero = true;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            //只有第一位字符是'-'时 才是负数
            if (i == 0) {
                if (c == '-') {
                    negativeNum = true;
                    skipZero = false;
                } else if (c == '+' || (c >= '0' && c <= '9')) {
                    if (c != '+' && c != '0') {
                        builder.append(c);
                    }
                    if (c == '0') {
                        skipZero = false;
                    }
                } else {
                    return 0;
                }

                continue;
            }

            if (c >= '0' && c <= '9') {
                if (c != '0') {
                    skipZero = true;
                    builder.append(c);
                } else {
                    if (skipZero) {
                        builder.append(c);
                    }
                }
            } else {
                break;
            }

        }
        String resultContent = builder.reverse().toString();
        int result = 0;
        for (int i = 0; i < resultContent.length(); i++) {
            char c = resultContent.charAt(i);
            int p = pow(10, i);
            if (i >= 1 && p == -1) {
                if (negativeNum) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            if ((c - '0') > Integer.MAX_VALUE / p) {
                if (negativeNum) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            if (result > Integer.MAX_VALUE - ((c - '0') * p)) {
                if (negativeNum) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            result = result + (c - '0') * pow(10, i);
        }

        if (negativeNum) {
            return -result;
        }


        return result;
    }

    private int pow(int base, int num) {
        if (num == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < num; i++) {
            if (result > Integer.MAX_VALUE / base) {
                return -1;
            }
            result = result * base;
        }
        return result;
    }
}
