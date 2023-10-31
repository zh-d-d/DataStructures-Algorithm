package com.zhangdd.leetcode.problem0141;

/**
 * @author zhangdd on 2022/12/8
 * <a href="https://leetcode.cn/problems/linked-list-cycle/description/">题目描述</a>
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}