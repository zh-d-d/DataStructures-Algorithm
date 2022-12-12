package com.zhangdd.leetcode.problem.part02.problem0121;

/**
 * @author zhangdd on 2022/12/8
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">题目描述</a>
 */
public class Solution121 {

    public static void main(String[] args) {
        Solution121 solution = new Solution121();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[] minValueDays = new int[prices.length];
        int tmpMinValue = 10000;
        for (int i = 0; i < prices.length; i++) {
            if (tmpMinValue > prices[i]) {
                minValueDays[i] = prices[i];
                tmpMinValue = prices[i];
            } else {
                minValueDays[i] = tmpMinValue;
            }
        }

        int maxValue = 0;
        for (int i = 0; i < prices.length; i++) {
            if (maxValue <= prices[i] - minValueDays[i]) {
                maxValue = prices[i] - minValueDays[i];
            }
        }
        return maxValue;
    }
}
