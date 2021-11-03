package com.zhangdd.sort;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/11/2
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {7, 3, 10, 2, 4, 1, 15, 21, 8, 3};
        int[] arr = {7, 3, 4};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }

    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int l = left;
        int r = mid + 1;
        int tempIndex = 0;

        //1.
        //将arr中，left到mid 和mid+1到right两个数组中的数按序填充到temp中
        //直到一个子数组空了
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[tempIndex] = arr[l];
                l++;
                tempIndex++;
            } else {
                temp[tempIndex] = arr[r];
                r++;
                tempIndex++;
            }
        }

        //2.
        //将剩余的一个子数组内的数据填充到temp中
        while (l <= mid) {
            temp[tempIndex] = arr[l];
            l++;
            tempIndex++;
        }

        while (r <= right) {
            temp[tempIndex] = arr[r];
            r++;
            tempIndex++;
        }

        tempIndex = 0;
        int tempLeft = left;
        //3.
        //将这次temp中填充的数据拷贝到arr中
        while (tempLeft <= right) {
            arr[tempLeft] = temp[tempIndex];
            tempIndex++;
            tempLeft++;
        }
    }
}
