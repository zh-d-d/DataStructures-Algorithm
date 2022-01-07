package com.zhangdd.leetcode.subjectunknow;

public class BinarySearchExample {
    public static void main(String[] args) {
        BinarySearchExample binarySearchExample = new BinarySearchExample();
        int[] arr = new int[]{1, 2, 2, 2, 3};
        System.out.println(binarySearchExample.binary_search(arr, 2));
        System.out.println(binarySearchExample.binary_serch_left_boud(arr, 2));
        System.out.println(binarySearchExample.binary_serch_right_boud(arr, 2));

    }

    public int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    public int binary_serch_left_boud(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                //锁定左侧边界
                right = mid - 1;
            }
        }
        //检查left越界情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int binary_serch_right_boud(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                //锁定右侧边界
                left = mid + 1;
            }
        }
        //检查right越界情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

}
