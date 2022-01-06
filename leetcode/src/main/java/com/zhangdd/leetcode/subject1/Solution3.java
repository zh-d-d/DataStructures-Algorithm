package com.zhangdd.leetcode.subject1;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "abcabcbb";
        System.out.println(solution3.lengthOfLongestSubstring(s));
    }

    /**
     * 987 / 987 个通过测试用例
     * 状态：通过
     * 执行用时: 2 ms
     * 内存消耗: 38.5 MB
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] cnt = new int[128];
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[s.charAt(left)]--;
                left++;
            }
            right++;
            if (res < right - left) {
                res = right - left;
            }
        }
        return res;
    }
}
