package com.zhangdd.leetcode.problem.part03.problem0228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2022/12/26
 * <a href="https://leetcode.cn/problems/summary-ranges/description/">题目描述</a>
 */
public class Solution228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            if (!(i + 1 < nums.length && nums[i] == nums[i + 1] - 1)) {
                if (sb.length() > 0) sb.append("->");
                sb.append(nums[i]);
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else {
                if (sb.length() == 0) sb.append(nums[i]);
            }
        }
        return ans;
    }
}
