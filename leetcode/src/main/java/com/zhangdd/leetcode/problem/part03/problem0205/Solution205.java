package com.zhangdd.leetcode.problem.part03.problem0205;

import java.util.HashMap;

/**
 * @author zhangdd on 2022/12/19
 * <a href="https://leetcode.cn/problems/isomorphic-strings/">题目描述</a>
 */
public class Solution205 {

    public static void main(String[] args) {
        Solution205 solution = new Solution205();
        System.out.println(solution.isIsomorphic("egg", "add"));
    }

    public boolean isIsomorphic(String s, String t) {
        /*
        HashMap建立双向映射
         */
        int len = s.length();
        HashMap<Character, Character> map1 = new HashMap<>();   // s[i]->t[i]
        HashMap<Character, Character> map2 = new HashMap<>();   // t[i]->s[i]
        for (int i = 0; i < len; i++) {
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            if (!map1.containsKey(ch1)) {
                map1.put(ch1, ch2);
            }
            if (!map2.containsKey(ch2)) {
                map2.put(ch2, ch1);
            }
            // 均存在的情况:排除掉不匹配的情况
            if (map1.get(ch1) != ch2 || map2.get(ch2) != ch1) return false;
        }
        // 最后所有都匹配的情况
        return true;
    }
}
