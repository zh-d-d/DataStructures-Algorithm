package com.zhangdd.leetcode.problem.part01.problem0023;

import java.util.Arrays;

/**
 * @author zhangdd on 2023/2/9
 *
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/discussion/">题目描述</a>
 */
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode[] tmpLists = Arrays.copyOfRange(lists, 1, lists.length);
        return mergeTwoList(lists[0], mergeKLists(tmpLists));
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }

        ListNode result = new ListNode();
        ListNode tmpHead = result;
        while (null != list1 && null != list2) {
            int value1 = list1.val;
            int value2 = list2.val;
            if (value1 > value2) {
                tmpHead.next = list2;
                list2 = list2.next;
            } else {
                tmpHead.next = list1;
                list1 = list1.next;
            }
            tmpHead = tmpHead.next;
        }
        if (null != list1) {
            tmpHead.next = list1;
        }
        if (null != list2) {
            tmpHead.next = list2;
        }

        return result.next;
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