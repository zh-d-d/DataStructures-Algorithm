package com.zhangdd.leetcode.problem.part01.problem0025;

/**
 * @author zhangdd on 2023/2/2
 *
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">题目描述</a>
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        //递归结束条件
        ListNode stopNode = head;
        for (int i = 0; i < k; i++) {
            //如果不够k个，那么这段链表不用处理
            if (null == stopNode) {
                return head;
            }
            stopNode = stopNode.next;
        }

        //反转链表（这里只反转部分）
        ListNode pre = null;
        ListNode cur = head;
        while (stopNode != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //继续处理后面的部分
        head.next = reverseKGroup(stopNode, k);

        return pre;
    }

    public ListNode reverseListNode(ListNode head) {
        ListNode newHead = null;//新链表头节点
        ListNode cur = head;//当前节点
        ListNode pre = null;//前一个节点
        while (null != cur) {
            //保存当前节点的下一个节点
            ListNode next = cur.next;
            if (null == next) {
                //说明原链表已经遍历到最后了
                newHead = cur;
            }
            //修改当前节点的指向
            cur.next = pre;
            //移动前节点到当前位置
            pre = cur;
            //移动当前节点到下一个位置
            cur = next;
        }
        return newHead;
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