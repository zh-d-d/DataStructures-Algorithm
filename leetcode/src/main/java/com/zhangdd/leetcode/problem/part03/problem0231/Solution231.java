package com.zhangdd.leetcode.problem.part03.problem0231;

/**
 * @author zhangdd on 2022/12/27
 * <a href="https://leetcode.cn/problems/power-of-two/">题目描述</a>
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
