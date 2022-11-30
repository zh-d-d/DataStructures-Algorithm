package com.zhangdd.leetcode.problem0020;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdd on 2022/11/30
 * <a href="https://leetcode.cn/problems/valid-parentheses/description/">题目描述</a>
 */
public class Solution20 {

    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        boolean isValid = false;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        CustomStack stack = new CustomStack(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.empty()) {
                    continue;
                }

                Character last = stack.pop();
                if (map.get(last) != c) {
                    isValid = false;
                    break;
                }
            } else {
                isValid = false;
                break;
            }
            if (i == s.length() - 1) {
                isValid = true;
            }
        }

        return isValid && stack.empty();
    }
}

class CustomStack {

    char[] arr;
    int topIndex = -1;

    public CustomStack(int size) {
        this.arr = new char[size];
    }

    public void push(char c) {
        topIndex++;
        arr[topIndex] = c;
    }

    public char pop() {
        char tmp = arr[topIndex];
        topIndex--;
        return tmp;
    }

    public boolean empty() {
        return topIndex == -1;
    }
}
