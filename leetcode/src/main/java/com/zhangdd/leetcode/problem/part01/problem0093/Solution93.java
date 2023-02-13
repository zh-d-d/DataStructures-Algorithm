package com.zhangdd.leetcode.problem.part01.problem0093;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2023/2/13
 *
 * <a href="https://leetcode.cn/problems/restore-ip-addresses/">题目描述</a>
 */
public class Solution93 {

    public static void main(String[] args) {
        Solution93 solution = new Solution93();
        List<String> result = solution.restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4) {
            return result;
        }

        for (int i = 1; i < s.length(); i++) {

            for (int j = i + 1; j < s.length(); j++) {
                int k = s.length() - 1;

                while (j < k) {
                    String str1 = s.substring(0, i);
                    String str2 = s.substring(i, j);
                    String str3 = s.substring(j, k);
                    String str4 = s.substring(k);

                    if (illegalIpNum(str1) && illegalIpNum(str2) && illegalIpNum(str3) && illegalIpNum(str4)) {
                        String builder = str1 + "." + str2 + "." + str3 + "." + str4;
                        result.add(builder);
                    }
                    k--;
                }
            }
        }

        return result;
    }

    private boolean illegalIpNum(String str) {
        int length = str.length();
        //如果长度 小于等于0 或者 大于等于4 那么这段都是不合法的
        if (length <= 0 || length >= 4) {
            return false;
        }
        //如果长度是 1 那么是合法的
        if (length == 1) {
            return true;
        }
        //到这里 str的长度 是两位或者三位
        //如果长度是 2位 或者 3位
        // 如果以0开始那么不合法
        // 如果非0开头 转换为数字，只要在 [1,255] 都是合法的
        if (str.startsWith("0")) {
            return false;
        }
        if (length == 3 && str.charAt(0) >= '3') {
            return false;
        }
        return Integer.parseInt(str) <= 255;
    }
}
