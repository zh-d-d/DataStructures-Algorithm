package com.zhangdd.leetcode.subject2;

import com.zhangdd.leetcode.subjectunknow.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution111 {

    /**
     * 执行用时：
     * 1 ms, 在所有 Java 提交中击败了97.61%的用户
     * 内存消耗：
     * 61 MB, 在所有 Java 提交中击败了7.61%的用户
     * 通过测试用例：
     * 52 / 52
     * while循环控制一层一层往下走 for循环控制从左到右遍历每一层二叉树结点
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是⼀层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将 cur 的相邻节点加⼊队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 这⾥增加步数 */
            depth++;
        }
        return depth;
    }
}
