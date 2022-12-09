package com.zhangdd.leetcode.problem0125;

/**
 * @author zhangdd on 2022/12/8
 * <a href="https://leetcode.cn/problems/valid-palindrome/">题目描述</a>
 */
public class Solution125 {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        Solution125 solution = new Solution125();
        System.out.println(solution.isPalindrome(str));
    }

    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if ((c >= 48 && c <= 57) || (c >= 97 && c <= 122)) {
                builder.append(c);
            }
        }
        String cleanedStr = builder.toString();

        int maxLength = cleanedStr.length();
        int halfLength = maxLength / 2;
        boolean result = true;
        for (int i = 0; i < halfLength; i++) {
            if (cleanedStr.charAt(i) != cleanedStr.charAt(maxLength - 1 - i)) {
                result = false;
                break;
            }
        }

        return result;
    }
}
