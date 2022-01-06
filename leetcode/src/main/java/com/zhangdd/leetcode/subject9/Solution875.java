package com.zhangdd.leetcode.subject9;

public class Solution875 {
    public static void main(String[] args) {
        Solution875 solution875 = new Solution875();
        int[] piles = new int[]{3, 6, 7, 11};
        System.out.println(solution875.minEatingSpeed(piles, 8));
    }

    /**
     * 119 / 119 个通过测试用例
     * 状态：通过
     * 执行用时: 12 ms
     * 内存消耗: 39.7 MB
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int n : piles) {
            time += (n / speed + ((n % speed > 0) ? 1 : 0));
        }
        return time <= h;
    }

}
