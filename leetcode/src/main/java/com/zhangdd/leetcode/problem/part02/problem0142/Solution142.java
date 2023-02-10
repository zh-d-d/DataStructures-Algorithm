package com.zhangdd.leetcode.problem.part02.problem0142;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangdd on 2023/2/10
 *
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/discussion/">题目描述</a>
 */
public class Solution142 {

    /**
     * 方式一，借助HashSet
     */
//    public ListNode detectCycle(ListNode head) {
//        if (null == head) {
//            return null;
//        }
//        Set<ListNode> data = new HashSet<>();
//
//        while (null != head) {
//            if (data.contains(head)) {
//                return head;
//            } else {
//                data.add(head);
//            }
//            head = head.next;
//        }
//        return null;
//    }

    /**
     * 方式二
     * 1.使用快慢指针 判断是否有环
     * 2.如果有环 当快慢指针相遇时，使快指针在重head开始，当快慢指针再次相遇时的节点就是环的入口
     */
    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }
        boolean hasCycle = false;
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            fast = head;

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }

        return null;
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
