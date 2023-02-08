package com.zhangdd.leetcode.problem.part01.problem0046;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangdd on 2023/2/8
 *
 * <a href="https://leetcode.cn/problems/permutations/">题目描述</a>
 */
public class Solution46 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> item = new LinkedList<>();



    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used);
        return result;
    }

    private void permuteHelper(int[] nums, boolean[] used) {

        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            item.add(nums[i]);

            permuteHelper(nums, used);

            item.removeLast();
            used[i] = false;

        }
    }

}
