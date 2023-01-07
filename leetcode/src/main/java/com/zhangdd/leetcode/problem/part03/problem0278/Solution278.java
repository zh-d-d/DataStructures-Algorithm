package com.zhangdd.leetcode.problem.part03.problem0278;

/**
 * @author zhangdd on 2023/1/7
 *
 * <a href="https://leetcode.cn/problems/first-bad-version/">题目描述</a>
 */
public class Solution278 {

    public int firstBadVersion(int n) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (!isBadVersion(mid)) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

}
