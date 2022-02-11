package com.zhangdd.leetcode.subject6;

import java.util.HashMap;

public class Solution560 {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer,Integer> hp = new HashMap<>();
            int sum=0,res=0;
            hp.put(0,1);
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                int dep=sum-k;
                if(hp.containsKey(dep)){
                    res+=hp.get(dep);
                }
                hp.put(sum,hp.getOrDefault(sum,0)+1);
            }
            return res;
        }

}
