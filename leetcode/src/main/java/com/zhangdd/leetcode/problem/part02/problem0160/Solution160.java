package com.zhangdd.leetcode.problem.part02.problem0160;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2022/12/8
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">题目描述</a>
 */
public class Solution160 {

    public static void main(String[] args) {
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (null == headA || null == headB) {
            return null;
        }
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != tmpB) {
            tmpA = null == tmpA ? headB : tmpA.next;
            tmpB = null == tmpB ? headA : tmpB.next;
        }
        return tmpA;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}