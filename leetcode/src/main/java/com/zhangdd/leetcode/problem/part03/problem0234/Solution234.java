package com.zhangdd.leetcode.problem.part03.problem0234;

/**
 * @author zhangdd on 2022/12/28
 *
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/">题目描述</a>
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = head;
        ListNode next = head;
        ListNode cur = head;
        int headSize = 0;
        while (cur != null) {
            cur = cur.next;
            headSize++;
        }
        if (headSize == 0 || headSize == 1) {
            return true;
        }
        int mid = headSize >> 1;
        if ((headSize & 1) == 1) {
            for (int i = 0; i < mid + 1; i++) {
                next = next.next;
            }
            next = reverseLinkedList(next);
            while (pre.val == next.val) {
                pre = pre.next;
                next = next.next;
                if (next == null) {
                    return true;
                }

            }
            return false;
        }
        for (int i = 0; i < mid; i++) {
            next = next.next;
        }
        next = reverseLinkedList(next);
        while (pre.val == next.val) {
            pre = pre.next;
            next = next.next;
            if (next == null) {
                return true;
            }

        }
        return false;

    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;

        }
        return pre;
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