package com.zhangdd.leetcode.problem.part03.problem0202;

/**
 * @author zhangdd on 2022/12/16
 * <a href="https://leetcode.cn/problems/happy-number/">题目描述</a>
 */
public class Solution202 {

    //参考英文网站热评第一。这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
    //如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
    //两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (slow != fast);
        return fast == 1;
    }

    private int squareSum(int m) {
        int squareSum = 0;
        while (m != 0) {
            squareSum += (m % 10) * (m % 10);
            m /= 10;
        }
        return squareSum;
    }
}
