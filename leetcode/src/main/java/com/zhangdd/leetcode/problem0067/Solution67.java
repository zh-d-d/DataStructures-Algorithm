package com.zhangdd.leetcode.problem0067;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/add-binary/">题目描述</a>
 */
public class Solution67 {

    public static void main(String[] args) {
        Solution67 solution = new Solution67();
        System.out.println(solution.addBinary("11", "1"));
    }


    public String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        int overValue = 0;
        int tmpValue = 0;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {

            int charA = getChar(a, i);
            int charB = getChar(b, i);
            tmpValue = (charA + charB + overValue) % 2;
            overValue = (charA + charB + overValue) / 2;
            builder.append(tmpValue);
        }
        if (overValue != 0) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }

    public int getChar(String s, int index) {
        if (s.length() - index - 1 < 0) {
            return 0;
        }

        return s.charAt(s.length() - index - 1) - 48;
    }

}
