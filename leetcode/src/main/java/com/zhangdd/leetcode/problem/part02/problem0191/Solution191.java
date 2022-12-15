package com.zhangdd.leetcode.problem.part02.problem0191;

/**
 * @author zhangdd on 2022/12/15
 * <a href="https://leetcode.cn/problems/number-of-1-bits/description/">题目描述</a>
 */
public class Solution191 {

    public static void main(String[] args) {
        Solution191 solution = new Solution191();
        int i = solution.hammingWeight(3);
        System.out.println(i);
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //不断的对二进制n进行减1的操作，然后记录count
            //#位运算，n & (n-1)可以将n中最后一位的1变为0
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
