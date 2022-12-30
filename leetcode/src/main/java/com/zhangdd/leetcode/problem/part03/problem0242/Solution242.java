package com.zhangdd.leetcode.problem.part03.problem0242;

import java.util.Arrays;

/**
 * @author zhangdd on 2022/12/30
 * <a href="https://leetcode.cn/problems/valid-anagram/">题目描述</a>
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        t.chars().forEach(tc -> counts[tc - 'a']++);
        s.chars().forEach(cs -> counts[cs - 'a']--);
        return Arrays.stream(counts).allMatch(c -> c == 0);
    }
}
