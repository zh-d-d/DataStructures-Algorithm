package com.zhangdd.leetcode.problem.part02.problem0148;

/**
 * @author zhangdd on 2023/2/11
 */
public class Solution148 {

    public static void main(String[] args) {
        Solution148 solution = new Solution148();
        //4,2,1,3
        ListNode root = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode result = solution.sortList(root);
    }


    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }


    /**
     * 归并排序
     */
    private ListNode mergeSort(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        //拆
        //定义快慢指针，进行遍历 当快指针到达末尾时 ，这个时候慢指针到达链表中间位置
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode slowNodePre = null;
        while (null != fastNode && null != fastNode.next) {
            slowNodePre = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        slowNodePre.next = null;

        ListNode left = mergeSort(head);

        ListNode right = mergeSort(slowNode);

        //合
        return merge(left, right);
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummyNode = new ListNode();
        ListNode tmpHead = dummyNode;
        while (null != one && null != two) {
            if (one.val < two.val) {
                tmpHead.next = one;
                one = one.next;
            } else {
                tmpHead.next = two;
                two = two.next;
            }

            tmpHead = tmpHead.next;
        }

        if (null != one) {
            tmpHead.next = one;
        }

        if (null != two) {
            tmpHead.next = two;
        }

        return dummyNode.next;
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