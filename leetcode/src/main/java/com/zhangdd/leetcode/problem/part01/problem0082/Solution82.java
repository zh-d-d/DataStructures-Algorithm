package com.zhangdd.leetcode.problem.part01.problem0082;

/**
 * @author zhangdd on 2023/2/12
 *
 *
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">题目描述</a>
 */
public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode preNode = dummyHead;

        while (null != head) {
            if (null != head.next && head.next.val == head.val) {
                while (null != head.next && head.next.val == head.val) {
                    head = head.next;
                }
                preNode.next = head.next;

            } else {
                preNode=head;

            }
            head = head.next;
        }

        return dummyHead.next;
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