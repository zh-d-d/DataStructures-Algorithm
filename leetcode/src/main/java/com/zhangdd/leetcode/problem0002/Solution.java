package com.zhangdd.leetcode.problem0002;

/**
 * @author zhangdd on 2022/11/30
 */
public class Solution {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        while (null != result.next) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;

        int value = 0;
        int overValue = 0;


        do {

            if (null != l1) {
                value = value + l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                value = value + l2.val;
                l2 = l2.next;
            }


            temp.val = (value + overValue) % 10;
            overValue = (value + overValue) / 10;

            if (null != l1 || null != l2 || 0 != overValue) {
                temp.next = new ListNode();
                temp = temp.next;
            }

            value = 0;

        } while (null != l1 || null != l2 || 0 != overValue);

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

