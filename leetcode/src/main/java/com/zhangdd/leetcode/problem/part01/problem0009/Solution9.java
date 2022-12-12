package com.zhangdd.leetcode.problem.part01.problem0009;

/**
 * @author zhangdd on 2022/11/30
 * <a href="https://leetcode.cn/problems/palindrome-number/">题目描述</a>
 */
public class Solution9 {

    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        System.out.println(solution.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int xCache = x;
        int temp = 0;
        int e = 0;
        while (0 != x) {
            e = x % 10;
            x = x / 10;
            temp = temp * 10 + e;
        }
        return xCache == temp;
    }
}
