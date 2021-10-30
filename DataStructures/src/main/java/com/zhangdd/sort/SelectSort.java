package com.zhangdd.sort;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/10/30
 */
public class SelectSort {

    public static void main(String[] args) {
        //从小到大排
        int[] arr = {1, 9, 7, -3, 2};


        for (int i = 0; i < arr.length -1; i++) {
            int minIndex = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
