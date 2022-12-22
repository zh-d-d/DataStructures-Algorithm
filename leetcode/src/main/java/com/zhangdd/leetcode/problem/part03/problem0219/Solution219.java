package com.zhangdd.leetcode.problem.part03.problem0219;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdd on 2022/12/22
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/">题目描述</a>
 */
public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                if ((i - map.get(nums[i]) <= k)) return true;
            }
            // 覆盖之后的位置和下一个相同值肯定离得更近
            map.put(nums[i], i);
        }
        return false;
    }
}
