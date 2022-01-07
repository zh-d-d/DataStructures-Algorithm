package com.zhangdd.leetcode.subject11;

public class Solution1011 {
    public static void main(String[] args) {
        Solution1011 solution1011 = new Solution1011();
        int[] weights = new int[]{1, 2, 3, 1, 1};
//        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};

        System.out.println(solution1011.shipWithinDays(weights, 5));
        System.out.println(solution1011.canLoad(weights, 3, 4));
    }

    /**
     * 85 / 85 个通过测试用例
     * 状态：通过
     * 执行用时: 10 ms
     * 内存消耗: 41.5 MB
     */
    public int shipWithinDays(int[] weights, int i) {
        int left = getMax(weights), right = getFullCapcity(weights);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canLoad(weights, mid, i)) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return left;
    }

    public boolean canLoad(int[] weights, int capcity, int days) {
        int need = 1, weight = 0;
        for (int h : weights) {
            if (weight + h > capcity) {
                ++need;
                weight = 0;
            }
            weight += h;

        }
        return need <= days ? true : false;
    }

    public int getFullCapcity(int[] weights) {
        int sum = 0;
        for (int h : weights) {
            sum += h;
        }
        return sum;
    }

    public int getMax(int[] weights) {
        int max = 0;
        for (int h : weights) {
            max = Math.max(max, h);
        }
        return max;
    }

}
