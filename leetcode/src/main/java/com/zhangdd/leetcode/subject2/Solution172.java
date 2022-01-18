package com.zhangdd.leetcode.subject2;

public class Solution172 {
    public static void main(String[] args) {
        Solution172 solution172 = new Solution172();
        System.out.println(solution172.trailingZeroes(125));
        System.out.println(solution172.trailingZeroes(126));

    }

    /**
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 35 MB, 在所有 Java 提交中击败了94.30%的用户
     * 通过测试用例：
     * 500 / 500
     */
    public int trailingZeroes(int n){
        int res=0;
        long divisor =5;
        while (divisor<=n){
            res+=n/divisor;
            divisor*=5;
        }
        return  res;
    }
}
