package com.zhangdd.leetcode.problem.part01.problem0019;

/**
 * @author zhangdd on 2023/2/10
 *
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">题目描述</a>
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return head;
        }

        //定义快慢指针，让快指针先走n个
        //然后快慢指针同时移动，当快指针移动到末尾时，慢指针就是倒数第n个
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (null != fastNode && n > 0) {
            fastNode = fastNode.next;
            n--;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;


        ListNode preNode = dummyHead;
        while (null != fastNode) {
            fastNode = fastNode.next;

            ListNode next = slowNode.next;
            preNode = slowNode;
            slowNode = next;
        }

        preNode.next = slowNode.next;
        slowNode.next = null;

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