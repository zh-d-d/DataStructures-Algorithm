package com.zhangdd.leetcode.problem.part01.problem0042;

/**
 * @author zhangdd on 2023/2/10
 *
 * <a href="https://leetcode.cn/problems/trapping-rain-water/">题目描述</a>
 */
public class Solution42 {

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        //得到数组中的最大值，以及最大值的下标索引位置
        int maxValue = 0;
        int maxValueIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxValue) {
                maxValue = height[i];
                maxValueIndex = i;
            }
        }

        int water = 0;

        //开始从左向右朝最大值遍历
        int leftMax = height[0];
        for (int i = 0; i < maxValueIndex; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } else {
                water = water + leftMax - height[i];
            }
        }

        //开始从右向左朝最大值遍历
        int rightMax = height[height.length - 1];
        for (int i = height.length - 1; i > maxValueIndex; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            } else {
                water = water + rightMax - height[i];
            }
        }

        return water;
    }
}
