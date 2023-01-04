package com.zhangdd.leetcode.problem.part03.problem0263;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangdd on 2023/1/4
 */
public class Solution263 {
    public boolean isUgly(int n) {
        List<Integer> integers = Arrays.asList(2, 3, 5);
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        for (int i = 0; i < integers.size(); i++) {
            while (n % integers.get(i) == 0) {
                n = n / integers.get(i);
            }
        }
        if (integers.contains(n) || n == 1) {
            return true;
        }
        return false;
    }
}
