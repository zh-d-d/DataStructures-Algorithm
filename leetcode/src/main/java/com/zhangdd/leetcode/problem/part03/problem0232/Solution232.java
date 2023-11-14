package com.zhangdd.leetcode.problem.part03.problem0232;

import java.util.Stack;

/**
 * @author zhangdd on 2022/12/27
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/">题目描述</a>
 */
public class Solution232 {

    class MyQueue {
        private Stack<Integer> a;// 输入栈
        private Stack<Integer> b;// 输出栈

        public MyQueue() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void push(int x) {
            a.push(x);
        }

        public int pop() {
            // 如果b栈为空，则将a栈全部弹出并压入b栈中，然后b.pop()
            if (b.isEmpty()) {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
            return b.pop();
        }

        public int peek() {
            if (b.isEmpty()) {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
            return b.peek();
        }

        public boolean empty() {
            return a.isEmpty() && b.isEmpty();
        }
    }
}
