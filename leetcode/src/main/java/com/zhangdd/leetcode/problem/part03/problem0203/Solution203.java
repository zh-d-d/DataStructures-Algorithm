package com.zhangdd.leetcode.problem.part03.problem0203;


/**
 * @author zhangdd on 2022/12/19
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/">题目描述</a>
 */
public class Solution203 {

    public static void main(String[] args) {
        Solution203 solution = new Solution203();
        //1,2,6,3,4,5,6
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        System.out.println(solution.removeElements(head, 6));
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return header.next;
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
