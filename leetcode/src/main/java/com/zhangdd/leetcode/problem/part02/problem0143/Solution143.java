package com.zhangdd.leetcode.problem.part02.problem0143;

/**
 * @author zhangdd on 2023/2/10
 *
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/discussion/">题目描述</a>
 */
public class Solution143 {

    public void reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }
        //找到链表的中间位置
        //快慢指针遍历，当快指针遍历到末尾时，这个时候慢指针到中间
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (null != fastNode && null != fastNode.next) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        //拆成两个链表
        ListNode newLinkHead = slowNode.next;
        slowNode.next = null;

        //将链表的后半部分进行反转
        ListNode pre = null;
        while (null != newLinkHead) {
            ListNode next = newLinkHead.next;
            newLinkHead.next = pre;
            pre = newLinkHead;
            newLinkHead = next;
        }

        //两部分交叉拼接
        ListNode headTmp = head;
        while (null != pre) {
            ListNode a = headTmp.next;
            ListNode b = pre.next;

            headTmp.next = pre;
            pre.next = a;

            headTmp = a;
            pre = b;
        }

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