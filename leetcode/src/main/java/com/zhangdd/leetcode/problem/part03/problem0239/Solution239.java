package com.zhangdd.leetcode.problem.part03.problem0239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangdd on 2023/2/13
 *
 * <a href="https://leetcode.cn/problems/power-of-two/">题目描述</a>
 */
public class Solution239 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        Solution239 solution = new Solution239();
        int[] result = solution.maxSlidingWindow(nums, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];

        MyDeque myDeque = new MyDeque();
        for (int i = 0; i < k; i++) {
            myDeque.add(nums[i]);
        }
        result[0] = myDeque.peek();

        for (int i = k; i < nums.length; i++) {
            myDeque.poll(nums[i - k]);
            myDeque.add(nums[i]);
            result[i - k + 1] = myDeque.peek();
        }

        return result;
    }


}

class MyDeque {

    private Deque<Integer> deque = new LinkedList<>();

    public void poll(int value) {
        if (!deque.isEmpty() && value == deque.peek()) {
            deque.poll();
        }
    }

    public void add(int value) {
        while (!deque.isEmpty() && value > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(value);
    }

    public int peek() {
        return deque.peek();
    }
}