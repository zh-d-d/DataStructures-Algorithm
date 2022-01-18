package com.zhangdd.leetcode.subject4;

import java.util.Random;

public class Solution398 {
    public static void main(String[] args) {
        Solution398 solution398 = new Solution398();
        int[] nums = new int[] {1,2,3,3,3};
        System.out.println(solution398.pick(3,nums));
        System.out.println(solution398.pick(3,nums));
        System.out.println(solution398.pick(3,nums));
    }

    public int pick(int target, int[] nums) {
        Random r = new Random();
        int n = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target) {
                //计算同一个target的个数
                n++;
                //我们以同一个数字的频数1/n的概率选出其中一个索引
                if (r.nextInt(n) == 0) index = i;
            }
        return index;

    }
}
