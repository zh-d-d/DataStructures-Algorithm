package com.zhangdd.leetcode.problem.part01.problem0001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdd on 2023/2/6
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> data = new HashMap<>(nums.length);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (data.containsKey(target - num)) {
                int j = data.get(target - num);
                result[0] = i;
                result[1] = j;
                return result;
            } else {
                data.put(num, i);
            }
        }

        return result;
    }
}
