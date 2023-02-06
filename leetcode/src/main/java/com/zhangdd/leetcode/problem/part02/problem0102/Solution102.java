package com.zhangdd.leetcode.problem.part02.problem0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangdd on 2023/2/6
 *
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">题目描述</a>
 */
public class Solution102 {

    public static void main(String[] args) {
        //3,9,20,null,null,15,7
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        Solution102 solution = new Solution102();
        solution.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        //创建一个队列，用于按顺序存放同 等级的节点
        Queue<TreeNode> queue = new LinkedList<>();
        //先将root放进队列
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> item = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                item.add(node.val);

                //处理当前节点的左右节点，这样保证了队列里的肯定是一个层级的

                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            result.add(item);
        }

        return result;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}