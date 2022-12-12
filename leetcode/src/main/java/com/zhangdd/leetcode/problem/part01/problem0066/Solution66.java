package com.zhangdd.leetcode.problem.part01.problem0066;

import java.util.stream.Stream;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/plus-one/">题目描述</a>
 */
public class Solution66 {


    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        Solution66 solution = new Solution66();
        Stream.of(solution.plusOne(digits)).forEach(System.out::println);
    }

    public int[] plusOne(int[] digits) {
        boolean hasOver = false;
        int incr = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                incr = 1;
            } else {
                if (hasOver) {
                    incr = 1;
                } else {
                    incr = 0;
                }
            }


            hasOver = ((digits[i] + incr) / 10) != 0;
            digits[i] = (digits[i] + incr) % 10;
        }
        if (hasOver) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        } else {
            return digits;
        }
    }

}
