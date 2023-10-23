package com.zhangdd.leetcode.problem0071;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/">题目描述</a>
 */
public class Solution71 {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode result = head;
        while (null != head.next) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return result;
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