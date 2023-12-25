package com.zhangdd.leetcode.problem.part01.problem0021;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">题目描述</a>
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode result = new ListNode();
//        //同时为空 直接返回就好了
//        if (null == list1 && null == list2) {
//            return null;
//        }
//        //其中一个为空 ，直接将不为空的后面的内容串过来 返回就好了
//        if (null == list1) {
//            result.val = list2.val;
//            result.next = list2.next;
//            return result;
//        }
//        if (null == list2) {
//            result.val = list1.val;
//            result.next = list1.next;
//            return result;
//        }
//
//        //两个都不为空，取一个小的节点，同时移动对应的传
//        int val1 = list1.val;
//        int val2 = list2.val;
//        if (val1 <= val2) {
//            result.val = val1;
//            list1 = list1.next;
//            result.next = mergeTwoLists(list1, list2);
//        } else {
//            result.val = val2;
//            list2 = list2.next;
//            result.next = mergeTwoLists(list1, list2);
//        }


        //优化
        ListNode result = new ListNode();
        //同时为空 直接返回就好了
        if (null == list1 && null == list2) {
            return null;
        }
        //其中一个为空 ，直接将不为空的后面的内容串过来 返回就好了
        if (null == list1) {
            result.next = list2;
            return result.next;
        }
        if (null == list2) {
            result.next = list1;
            return result.next;
        }
        ListNode tmp = result;
        while (null != list1 && null != list2) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 <= val2) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        if (null != list1) {
            tmp.next = list1;
        } else {
            tmp.next = list2;
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