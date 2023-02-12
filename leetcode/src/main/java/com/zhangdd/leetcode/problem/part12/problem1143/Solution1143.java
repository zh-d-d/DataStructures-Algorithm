package com.zhangdd.leetcode.problem.part12.problem1143;

/**
 * @author zhangdd on 2023/2/12
 *
 * <a href="https://leetcode.cn/problems/longest-common-subsequence/">题目描述</a>
 * <p>
 * 300.最长递增子序列
 * 674.最长连续递增序列
 * 718.最长重复子数组
 * 1143.最长公共子序列
 * 1035.不相交的线
 * 53.最大子序和
 * 392.判断子序列
 * 115.不同的子序列
 * 583.两个字符串的删除操作
 * 72.编辑距离
 * 647.回文子串
 * 516.最长回文子序列
 */
public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
