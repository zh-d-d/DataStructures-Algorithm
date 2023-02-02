package com.zhangdd.leetcode.problem.part03.problem0206;

/**
 * @author zhangdd on 2022/12/20
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">题目描述</a>
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode newHead = null;
        ListNode pre = null;
        ListNode cur = head;
        while (null != cur) {
            ListNode next = cur.next;
            if (null == next) {
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}