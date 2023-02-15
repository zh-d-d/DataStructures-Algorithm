package com.zhangdd.leetcode.problem.part02.problem0151;

/**
 * @author zhangdd on 2023/2/14
 *
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">题目描述</a>
 */
public class Solution151 {

    public static void main(String[] args) {
        Solution151 solution = new Solution151();
        String str = "the sky is blue";
        String result = solution.reverseWords(str);
    }

    public String reverseWords(String s) {
        s = s.trim();

        //移除字符串内多余的空格（多个连续的只保留一个）
        StringBuilder sb = removeSpace(s);

        //反转字符串
        reverseString(sb, 0, sb.length() - 1);

        int start = 0;

        for (int i = 0; i < sb.length(); i++) {
            while (i < sb.length() && sb.charAt(i) != ' ') {
                i++;
            }
            reverseString(sb, start, i - 1);
            start = i+1;
        }


        return sb.toString();
    }

    private StringBuilder removeSpace(String str) {
        StringBuilder builder = new StringBuilder();
        int start = 0;
        int end = str.length();
        while (start < end) {
            char c = str.charAt(start);
            if (c != ' ' || builder.charAt(builder.length() - 1) != ' ') {
                builder.append(c);
            }
            start++;
        }
        return builder;
    }

    private void reverseString(StringBuilder builder, int start, int end) {
        while (start < end) {
            char c = builder.charAt(start);

            builder.setCharAt(start, builder.charAt(end));
            builder.setCharAt(end, c);

            start++;
            end--;
        }
    }


}
