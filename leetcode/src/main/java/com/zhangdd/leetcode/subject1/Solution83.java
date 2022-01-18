package com.zhangdd.leetcode.subject1;

import com.zhangdd.leetcode.subjectunknow.ListNode;

import java.util.Arrays;

public class Solution83 {
    public static void main(String[] args) {
        Solution83 solution83 = new Solution83();
        ListNode listNode = new ListNode(1, new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(3)))));

        System.out.println(solution83.deleteDuplicates(listNode));
    }

    /**
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 38 MB, 在所有 Java 提交中击败了49.64%的用户
     * 通过测试用例：
     * 166 / 166
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            System.out.println(fast.val + "----");
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }

        slow.next = null;

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        return head;
    }

}


