package com.zhangdd.leetcode.problem.part01.problem0003;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangdd on 2023/2/2
 *
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">题目描述</a>
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> container = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (container.contains(c)) {
                container.remove(s.charAt(left));
                left++;
            } else {
                container.add(s.charAt(right));
                right++;
            }

            maxLength = Math.max(maxLength, container.size());
        }

        return maxLength;
    }

}
