package com.zhangdd.leetcode.problem.part01.problem0088;


/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">题目描述</a>
 */
public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmpNums1 = new int[m];
        System.arraycopy(nums1, 0, tmpNums1, 0, tmpNums1.length);

        int maxLength = Math.max(m, n);
        int tmpNum1 = 0;
        int tmpNum2 = 0;
        int tmpNum = 0;
        boolean num1End = false, num2End = false;
        for (int i = 0, j = 0, k = 0; k < nums1.length; k++) {
            //处理nums1中的数据
            if (i >= m) {
                num1End = true;
            } else {
                tmpNum1 = tmpNums1[i];
            }

            //处理nums2中的数据
            if (j >= n) {
                num2End = true;
            } else {
                tmpNum2 = nums2[j];
            }

            //两个都没结束，取较小的
            if (!num1End && !num2End) {
                if (tmpNum1 <= tmpNum2) {
                    tmpNum = tmpNum1;
                    i++;
                } else {
                    tmpNum = tmpNum2;
                    j++;
                }
            } else if (num1End) {//数组1结束了
                tmpNum = tmpNum2;
                j++;
            } else {//数组2结束了
                tmpNum = tmpNum1;
                i++;
            }

            nums1[k] = tmpNum;
        }
    }


}

