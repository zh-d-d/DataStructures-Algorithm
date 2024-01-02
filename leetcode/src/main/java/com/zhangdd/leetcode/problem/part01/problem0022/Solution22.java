package com.zhangdd.leetcode.problem.part01.problem0022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2023/2/13
 *
 * <a href="https://leetcode.cn/problems/generate-parentheses/">题目描述</a>
 * <p>
 * 使用n-1的结果构建n，n-1中的每个结果找到最后一个'('的下个位置开始遍历直到结尾，每个位置都插入"()"
 */
public class Solution22 {

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        List<String> result = solution.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            result.add("()");
            return result;
        }
        List<String> tmp = generateParenthesis(n - 1);
        List<String> newContent = new ArrayList<>();
        for (String item : tmp) {
            int j = lastIndex(item, '(');
            j++;
            for (; j <= item.length(); j++) {
                newContent.add(append(item, j, "()"));
            }
        }
        return newContent;
    }

    private String append(String str, int index, String content) {
        String preContent = str.substring(0, index);
        String postContent = str.substring(index);
        return preContent + content + postContent;
    }

    private int lastIndex(String str, char c) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }


}
