package com.zhangdd.leetcode.problem.part01.problem0031;

/**
 * @author zhangdd on 2023/2/12
 *
 * <a href="https://leetcode.cn/problems/next-permutation/discussion/">题目描述</a>
 * <p>
 * 例如 2, 6, 3, 5, 4, 1 这个排列， 我们想要找到下一个刚好比他大的排列，
 * 于是可以从后往前看 我们先看后两位 4, 1 能否组成更大的排列，答案是不可以，同理 5, 4, 1也不可以
 * 直到3, 5, 4, 1这个排列，因为 3 < 5，
 * 我们可以通过重新排列这一段数字，来得到下一个排列
 * 因为我们需要使得新的排列尽量小，所以我们从后往前找第一个比3更大的数字，发现是4 然后，我们调换3和4的位置，
 * 得到4, 5, 3, 1这个数列 因为我们需要使得新生成的数列尽量小，
 * 于是我们可以对5, 3, 1进行排序，
 * 可以发现在这个算法中，我们得到的末尾数字一定是倒序排列的，于是我们只需要把它反转即可
 * 最终，我们得到了4, 1, 3, 5这个数列 完整的数列则是2, 6, 4, 1, 3, 5
 */
public class Solution31 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 7, 5, 3, 2};
        Solution31 solution = new Solution31();
        solution.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        boolean flag = true;
        int stopIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                flag = false;
                stopIndex = i - 1;
                break;
            }
        }
        //如果flag为true，说明原数组元素是递减的，直接反转返回
        if (flag) {
            revert(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[stopIndex]) {
                int tmp = nums[i];
                nums[i] = nums[stopIndex];
                nums[stopIndex] = tmp;
                break;
            }
        }

        revert(nums, stopIndex + 1, nums.length - 1);


    }

    /**
     * 对数组进行反转
     */
    private void revert(int[] nums, int startIndex, int stopIndex) {
        int length = stopIndex - startIndex + 1;
        int flagIndex = length / 2 + startIndex;
        for (int i = startIndex; i < flagIndex; i++) {
            int tmp = nums[stopIndex - i + startIndex];
            nums[stopIndex - i + startIndex] = nums[i];
            nums[i] = tmp;
        }
    }
}
