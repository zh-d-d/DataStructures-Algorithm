package com.zhangdd.leetcode.subject4;


import com.zhangdd.leetcode.subjectunknow.ListNode;

import java.util.Random;

public class Solution382 {
    public static void main(String[] args) {
        Solution382 solution382 = new Solution382();
    }

    /**
     * 执行用时：
     * 13 ms, 在所有 Java 提交中击败了16.18%的用户
     * 内存消耗：
     * 40.5 MB, 在所有 Java 提交中击败了21.85%的用户
     * 通过测试用例：
     * 8 / 8
     */
    public int getRandom(ListNode head) {
        Random r = new Random();
        int i = 0, res = 0;
        ListNode p = head;
        while (p != null) {
            i++;
            if (0 == r.nextInt(i)) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
