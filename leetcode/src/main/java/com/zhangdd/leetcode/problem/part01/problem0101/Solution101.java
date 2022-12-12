package com.zhangdd.leetcode.problem.part01.problem0101;


/**
 * @author zhangdd on 2022/12/1
 * <a href="https://leetcode.cn/problems/symmetric-tree/description/">题目描述</a>
 */
public class Solution101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode();

        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(3);

        Solution101 solution = new Solution101();
        System.out.println(solution.isSymmetric(root));
    }


    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if (null == tree1 && null == tree2) {
            return true;
        } else if (null != tree1 && null == tree2) {
            return false;
        } else if (null == tree1) {
            return false;
        } else if (tree1.val != tree2.val) {
            return false;
        }

        boolean leftRightResult = isSymmetric(tree1.left, tree2.right);
        boolean rightLeftResult = isSymmetric(tree1.right, tree2.left);

        return leftRightResult && rightLeftResult;
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

