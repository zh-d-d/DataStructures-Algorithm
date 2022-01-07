package com.zhangdd.leetcode.subject9;

import javax.lang.model.util.Elements;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Solution870 {
    public static void main(String[] args) {
        Solution870 solution870 = new Solution870();
        int[] nums1=new int[]{12,24,8,32};
        int[] nums2=new int[]{13,25,32,11};
        System.out.println(Arrays.toString(solution870.advantageCount(nums1,nums2)));
    }

    /**
     * 执行用时：
     * 68 ms, 在所有 Java 提交中击败了76.21%的用户
     * 内存消耗：
     * 52.6 MB, 在所有 Java 提交中击败了90.31%的用户
     * 通过测试用例：
     * 67 / 67
     * 田忌赛马 贪心
     */
    public int[] advantageCount(int[] nums1,int[] nums2){
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });
        for(int i=0;i<nums2.length;i++){
            maxpq.offer(new int[]{i,nums2[i]});
        }

        Arrays.sort(nums1);

        int left=0,right=nums1.length-1;
        int[] arr= new int[nums1.length];

        while (!maxpq.isEmpty()){
            int[] pair=maxpq.poll();
            int i=pair[0],maxval=pair[1];
            if (maxval<nums1[right]){
                //如果大于maxval 自己上
                arr[i]=nums1[right];
                right--;
            }else{
                //否则用最小值代替
                arr[i]=nums1[left];
                left++;
            }

        }
        return arr;
    }
}
