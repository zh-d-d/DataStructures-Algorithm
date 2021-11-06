package com.zhangdd.sort;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/11/4
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 2, 4, 1, 15, 21, 8, 3};

        radixSort(arr);


        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {

        int max = arr[0];
        int maxLength = String.valueOf(max).length();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxLength = String.valueOf(max).length();
            }
        }

        int[][] bucket = new int[10][arr.length];
        int[] bucketIndexSet = new int[arr.length];
        int k = 0;

        for (int m = 0,n=1; m < maxLength; m++,n *= 10) {

            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = arr[i] / n % 10;

                bucket[bucketIndex][bucketIndexSet[bucketIndex]] = arr[i];
                bucketIndexSet[bucketIndex]++;
            }

            k = 0;
            for (int i = 0; i < bucket.length; i++) {

                for (int j = 0; j < bucketIndexSet[i]; j++) {
                    arr[k] = bucket[i][j];
                    k++;
                }
                bucketIndexSet[i] = 0;
            }
        }
    }

    private static void radixSortProcess(int[] arr) {

        int[][] bucket = new int[10][arr.length];
        int[] bucketIndexSet = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = arr[i] % 10;

            bucket[bucketIndex][bucketIndexSet[bucketIndex]] = arr[i];
            bucketIndexSet[bucketIndex]++;
        }

        int k = 0;
        for (int i = 0; i < bucket.length; i++) {

            for (int j = 0; j < bucketIndexSet[i]; j++) {
                arr[k] = bucket[i][j];
                k++;
            }
            bucketIndexSet[i] = 0;
        }

        //第二圈
        k = 0;
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = arr[i] / 10 % 100;

            bucket[bucketIndex][bucketIndexSet[bucketIndex]] = arr[i];
            bucketIndexSet[bucketIndex]++;
        }

        for (int i = 0; i < bucket.length; i++) {

            for (int j = 0; j < bucketIndexSet[i]; j++) {
                arr[k] = bucket[i][j];
                k++;
            }
        }
    }

}
