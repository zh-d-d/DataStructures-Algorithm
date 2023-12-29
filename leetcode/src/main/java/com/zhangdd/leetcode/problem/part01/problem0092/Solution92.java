package com.zhangdd.leetcode.problem.part01.problem0092;

/**
 * @author zhangdd on 2023/2/9
 *
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/">题目描述</a>
 */
public class Solution92 {

    public static void main(String[] args) {
        Solution92 solution = new Solution92();
//        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode root = new ListNode(3, new ListNode(5));
        ListNode node = solution.reverseBetween(root, 1, 2);

    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (null == head.next) {
            return head;
        }
        if (left == right) {
            return head;
        }

        ListNode startNode = null;
        ListNode startNodePre = null;
        ListNode endNode = null;
        ListNode endNodeNext = null;

        int i = 1;
        ListNode headTmp = head;
        ListNode headPreTmp = null;
        while (null == startNode || null == endNode) {
            if (i == left) {
                startNode = headTmp;
                startNodePre = headPreTmp;
            }
            if (i == right) {
                endNode = headTmp;
                endNodeNext = endNode.next;
            }
            i++;
            headPreTmp = headTmp;
            headTmp = headTmp.next;
        }


        int size = right - left;
        ListNode tmpPre = endNodeNext;
        while (size >= 0) {
            ListNode next = startNode.next;

            startNode.next = tmpPre;
            tmpPre = startNode;
            startNode = next;
            size--;
        }

        if (null != startNodePre) {
            startNodePre.next = tmpPre;
            return head;
        } else {
            return tmpPre;
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