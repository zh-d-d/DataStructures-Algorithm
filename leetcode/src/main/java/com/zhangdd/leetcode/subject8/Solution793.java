package com.zhangdd.leetcode.subject8;

public class Solution793 {
    public static void main(String[] args) {
        Solution793 solution793 = new Solution793();
        System.out.println(solution793.preimageSizeFZF(12));
    }

    /**
     * 执行用时：
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：
     * 34.9 MB , 在所有 Java 提交中击败了92.49%的用户
     * 通过测试用例：
     * 44 / 44
     */
    public int preimageSizeFZF(int K){
        int res=0;
        res=(int)(right_bound(K)-left_bound(K)+1);
        return res;
    }

    public long right_bound(int target) {
        long lo=0,hi=Long.MAX_VALUE;
        while (lo<hi){
            long mid=lo+(hi-lo)/2;
            if(trailingZeroes(mid)>target){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }

        return lo-1;
    }

    public long left_bound(int target) {
        long lo=0,hi=Long.MAX_VALUE;
        while (lo<hi){
            long mid=lo+(hi-lo)/2;
            if (trailingZeroes(mid)<target){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }

        return lo;
    }

    public long trailingZeroes(long n){
        long res=0;
        long divisor =5;
        while (divisor<=n){
            res+=n/divisor;
            divisor*=5;
        }
        return  res;
    }

}
