package com.zhangdd.leetcode.subject7;

public class Solution645 {
    public static void main(String[] args) {
        Solution645 solution645 = new Solution645();
        int[] nums = new int[]{1,2,2,4};
        System.out.println(solution645.findErrorNums(nums));
        System.out.println(solution645.findErrorNumsBit(nums));

    }

    /**
     * 执行用时：
     * 11 ms, 在所有 Java 提交中击败了29.58%的用户
     * 内存消耗：
     * 39.9 MB, 在所有 Java 提交中击败了67.47%的用户
     * 通过测试用例：
     * 49 / 49
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }

        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i+1;
            }
        }
        System.out.println(dup+"-"+missing);
        return new int[]{dup, missing};
    }


    public int[] findErrorNumsBit(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int lowbit = xor & (-xor);
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lowbit) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        for (int num : nums) {
            if (num == num1) {
                return new int[]{num1, num2};
            }
        }
        System.out.println(num2+"-"+num1);

        return new int[]{num2, num1};
    }


}
