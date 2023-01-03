package com.zhangdd.leetcode.problem.part03.problem0258;

/**
 * @author zhangdd on 2023/1/3
 * <a href="https://leetcode.cn/problems/add-digits/">题目描述</a>
 */
public class Solution258 {
    public int addDigits(int num) {
        while (num / 10 != 0) {
            num = num % 10 + num / 10;
        }
        return num;
    }
}
