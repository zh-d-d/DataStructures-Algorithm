package com.zhangdd.leetcode.problem.part01.problem0078;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2023/2/16
 *
 * <a href="https://leetcode.cn/problems/subsets/">题目描述</a>
 */
public class Solution78 {

    public static void main(String[] args) {
        Solution78 solution = new Solution78();
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> result = solution.subsets(nums);

    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, nums.length); i++) {

            List<Integer> tmpNum = new ArrayList<>();
            int tmp = i;
            int tmpIndex = nums.length - 1;
            do {

                if ((tmp & 1) == 1) {
                    tmpNum.add(nums[tmpIndex]);
                }

                tmp = tmp >> 1;
                --tmpIndex;

            }
            while (tmp > 0);

            result.add(tmpNum);

        }
        return result;


    }


//    public List<List<Integer>> subsets(int[] nums) {
//
//        List<List<List<Integer>>> dp = new ArrayList<>(nums.length + 1);
//        List<List<Integer>> dpItem = new ArrayList<>();
//
//        dp.add(0, new ArrayList<>());
//
//
//        for (int i = 0; i < nums.length; i++) {
//            int value = nums[i];
//
//            List<List<Integer>> tmpItem = dp.get(dp.size() - 1);
//
//
//            List<List<Integer>> newItem = new ArrayList<>();
//            if (tmpItem.size() == 0) {
//                newItem.add(new ArrayList<>());
//            } else {
//                newItem.addAll(tmpItem);
//            }
//
//            List<Integer> valueList = new ArrayList<>();
//            valueList.add(value);
//            newItem.add(valueList);
//
//
//            for (List<Integer> item : tmpItem) {
//                if (item.size() == 0) {
//                    continue;
//                }
//                List<Integer> itemNew = new ArrayList<>(item);
//                itemNew.add(value);
//
//                newItem.add(itemNew);
//            }
//
//            dp.add(i + 1, newItem);
//        }
//
//        return dp.get(nums.length);
//    }
}
