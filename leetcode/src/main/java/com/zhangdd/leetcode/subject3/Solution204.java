package com.zhangdd.leetcode.subject3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution204 {
    public static void main(String[] args) {
        Solution204 solution204 = new Solution204();
        System.out.println(solution204.countPrimes(10));
        System.out.println(solution204.countPrimeslinear(10));
        System.out.println(solution204.countPrimesOdd(10));

    }


    /**
     * 执行用时：
     * 252 ms, 在所有 Java 提交中击败了12.97%的用户
     * 内存消耗：
     * 64.6 MB, 在所有 Java 提交中击败了37.49%的用户
     * 通过测试用例：
     * 66 / 66
     *
     * 埃氏筛
     */
    public int countPrimes(int n ){
        int count=0;
        Boolean[] isPrime = new Boolean[n];
        Arrays.fill(isPrime,true);

        for (int i=2;i*i<n;i++){
            if (isPrime[i]){
                for (int j=i*i;j<n;j+=i){
                    isPrime[j]=false;
                }
            }
        }

        for (int i=2;i<n;i++){
            if (isPrime[i]){
                count++;
            }
        }
        return count;
    }


    /**
     * 执行用时：
     * 267 ms, 在所有 Java 提交中击败了9.69% 的用户
     * 内存消耗：
     * 80.1 MB, 在所有 Java 提交中击败了5.17%的用户
     * 通过测试用例：
     * 66 / 66
     *
     * 线性筛
     */
    public int countPrimeslinear(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }


    /**
     * 执行用时：
     * 70 ms, 在所有 Java 提交中击败了96.24%的用户
     * 内存消耗：
     * 42.3 MB , 在所有 Java 提交中击败了95.45%的用户
     * 通过测试用例：
     * 66 / 66
     *
     * 奇数筛选
     */
    public int countPrimesOdd(int n){
        int count=n>2?1:0;
        int b= (int) Math.sqrt(n);
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        for (int i=3;i<n;i+=2){
            if (isPrime[i]){
                count++;
                if (i<=b){
                    for (int j=i;i*j<n;j+=2){
                        isPrime[i*j]=false;
                    }
                }
            }
        }

        return count;
    }

}
