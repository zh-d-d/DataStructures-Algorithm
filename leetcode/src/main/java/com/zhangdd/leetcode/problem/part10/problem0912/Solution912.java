package com.zhangdd.leetcode.problem.part10.problem0912;

/**
 * @author zhangdd on 2023/2/3
 *
 * <a href="https://leetcode.cn/problems/sort-an-array/">题目描述</a>
 */
public class Solution912 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};
        Solution912 s = new Solution912();
        s.sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int[] sortArray(int[] nums) {
        countSort(nums);
        return nums;
    }


    private void countSort(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        //遍历获取 nums 数组中的最大值 和 最小值
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }

        //使用 最大值 和 最小值 定义一个数组
        int[] valueNums = new int[maxValue - minValue + 1];

        //将nums中的元素，作为valueNums的下标 为 valueNums 数组计数
        //避免nums中存储负数，所以可以做一个偏差即 减去 nums中的最小值，保证得到的 valueNums 的下标不会为负数
        //如果 nums 中有负数，相当于整体向右正方向移动 到 0
        for (int num : nums) {
            valueNums[num - minValue]++;
        }

        int index = 0;
        //遍历 valueNums
        for (int i = minValue; i <= maxValue; i++) {
            int value = valueNums[i - minValue];
            while (value > 0) {
                nums[index] = i;
                index++;
                value--;
            }
        }
    }
}
