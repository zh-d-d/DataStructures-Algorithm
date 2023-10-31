package com.zhangdd.leetcode.problem.part01.problem0058;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/length-of-last-word/">题目描述</a>
 */
public class Solution58 {

    public static void main(String[] args) {
        String str = "   aa";
        Solution58 solution = new Solution58();
        System.out.println(solution.lengthOfLastWord(str));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() <= 1) {
            return s.length();
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                return s.length() - i - 1;
            }
        }
        return s.length();
    }

}
