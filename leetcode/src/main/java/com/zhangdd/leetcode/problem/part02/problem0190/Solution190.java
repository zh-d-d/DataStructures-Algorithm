package com.zhangdd.leetcode.problem.part02.problem0190;

/**
 * @author zhangdd on 2022/12/15
 * <a href="https://leetcode.cn/problems/reverse-bits/">题目描述</a>
 */
public class Solution190 {

    public static void main(String[] args) {

    }

    public int reverseBits(int n) {
        int ret = 0;
        //取n最低位放在ret对应位置，n循环右移
        for(int i = 0; i < 32 && n != 0; ++i){
            ret |= ((n & 1)<<(31-i));
            n >>>= 1;
        }
        return ret;
    }
}
