package com.zhangdd.leetcode.problem.part01.problem0015;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2023/2/2
 *
 * <a href="https://leetcode.cn/problems/3sum/">题目描述</a>
 */
public class Solution15 {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            //如果三元组第一个元素都大于0，那么则不可能构成
            if (nums[i] > 0) {
                return result;
            }

            //非首位元素，在递增过程中去重，保证得到的三元组没有不会有重复的 即 去重重复的递增指针值
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }

            // 构造 三元组的元素 即 i, left, right
            int left = i + 1;
            int right = nums.length - 1;


            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    result.add(item);

                    //获得当前三元组之后，left要前进一位，寻找下一个三元组，同时递增后的left值不能与上一个相同
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    //对于不同的left，当前right的值肯定无法构成三元组，因此right 递减到下一个不同的值
                    right--;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                }
            }


        }

        return result;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int target = nums[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && target <= nums[j]) {
                j--;
            }
            while (i < j && nums[i] <= target) {
                i++;
            }
            swap(nums, i, j);
        }

        swap(nums, i, left);

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
