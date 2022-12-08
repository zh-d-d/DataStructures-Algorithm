package com.zhangdd.leetcode.problem0118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2022/12/8
 * <a href="https://leetcode.cn/problems/pascals-triangle/">题目描述</a>
 */
public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 1) {
            result.add(List.of(1));
            return result;
        }
        if (numRows == 2) {
            result.add(List.of(1));
            result.add(List.of(1, 1));
            return result;
        }
        result.add(List.of(1));
        result.add(List.of(1, 1));

        for (int i = 2; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    item.add(1);
                    continue;
                }
                List<Integer> preList = result.get(i - 1);
                item.add(preList.get(j - 1) + preList.get(j));
            }
            result.add(item);
        }

        return result;
    }
}
