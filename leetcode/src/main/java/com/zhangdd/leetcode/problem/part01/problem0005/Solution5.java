package com.zhangdd.leetcode.problem.part01.problem0005;

/**
 * @author zhangdd on 2023/2/7
 *
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">题目描述</a>
 */
public class Solution5 {

    public String longestPalindrome(String s) {

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String palindrome1 = palindrome(s, i, i);
            String palindrome2 = palindrome(s, i, i + 1);

            result = result.length() > palindrome1.length() ? result : palindrome1;
            result = result.length() > palindrome2.length() ? result : palindrome2;
        }

        return result;
    }

    /**
     * 获取以 left，right为起始点 str的最长回文串
     */
    private String palindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        //这个时候的left 和 right 所对应的元素是不相等的，所以回文的子串是[left+1,right)
        //注意substring 开闭 左包含 右不包含
        return str.substring(left + 1, right);
    }
}
