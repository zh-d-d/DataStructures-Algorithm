package com.zhangdd.leetcode.problem.part04.problem0326;

/**
 * @author zhangdd on 2023/1/16
 *
 * <a href="https://leetcode.cn/problems/power-of-three/">题目描述</a>
 */
public class Solution326 {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467%n == 0;
    }
}
