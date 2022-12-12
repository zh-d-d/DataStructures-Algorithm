package com.zhangdd.leetcode.problem.part01.problem0069;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/sqrtx/description/">题目描述</a>
 */
public class Solution69 {

    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (middle < x / middle) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left == (x / left) ? left : left - 1;
    }
}
