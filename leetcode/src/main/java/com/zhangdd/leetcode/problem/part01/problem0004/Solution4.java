package com.zhangdd.leetcode.problem.part01.problem0004;

/**
 * @author zhangdd on 2023/2/11
 *
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">题目描述</a>
 */
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return (double) 0;
        }
        int[] arr = new int[nums1.length + nums2.length];
        int k = 0, i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                arr[k] = nums2[j];
                j++;
            } else {
                arr[k] = nums1[i];
                i++;
            }
            k++;
        }

        while (i < nums1.length) {
            arr[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            arr[k] = nums2[j];
            j++;
            k++;
        }

        int middleIndex = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (double) (arr[middleIndex - 1] + arr[middleIndex]) / 2;
        } else {
            return (double) arr[middleIndex];
        }
    }
}
