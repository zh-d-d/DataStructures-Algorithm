package com.zhangdd.leetcode.problem.part02.problem0100;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/same-tree/">题目描述</a>
 */
public class Solution100 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(1);


        TreeNode q = new TreeNode(1);
        q.left = null;
        q.right = new TreeNode(1);

        Solution100 solution = new Solution100();

        System.out.println(solution.isSameTree(p, q));

    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> resultP = new ArrayList<>();
        ArrayList<Integer> resultQ = new ArrayList<>();
        inorderTraversal(p, resultP);
        inorderTraversal(q, resultQ);

        if (resultP.size() != resultQ.size()) {
            return false;
        }
        boolean result = true;
        for (int i = 0; i < resultP.size(); i++) {
            Integer integer1 = resultP.get(i);
            Integer integer2 = resultQ.get(i);
            if (null == integer1 && null != integer2) {
                result = false;
                break;
            }
            if (null != integer1 && !integer1.equals(integer2)) {
                result = false;
                break;
            }
        }

        return result;
    }


    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (null == root) {
            result.add(null);
            return;
        }
        result.add(root.val);
        inorderTraversal(root.left, result);
        inorderTraversal(root.right, result);
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

