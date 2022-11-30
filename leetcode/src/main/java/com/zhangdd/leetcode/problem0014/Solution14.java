package com.zhangdd.leetcode.problem0014;

/**
 * @author zhangdd on 2022/11/30
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">题目描述</a>
 */
public class Solution14 {

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strArr) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; ; i++) {
            char c = 0;
            boolean hasEnd = false;
            for (int j = 0; j < strArr.length; j++) {
                //已经有字符串到末尾了
                if (i >= strArr[j].length()) {
                    hasEnd = true;
                    break;
                }
                if (j == 0) {
                    c = strArr[j].charAt(i);
                } else {
                    if (c != strArr[j].charAt(i)) {
                        hasEnd = true;
                        break;
                    }
                }
            }
            if (hasEnd) {
                break;
            }
            builder.append(c);
        }

        return builder.toString();
    }
}
