package com.zhangdd.sort;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/10/31
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {7, 3, 10, 2, 4, 1, 15, 21, 8, 3};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        if (l < r) {
            int emptyIndex = (l + r) / 2;
            int pivot = arr[emptyIndex];
            while (l < r) {

                //从左向右找，不能越界，找比中轴大的值
                while (l < emptyIndex && arr[l] <= pivot) {
                    l++;
                }
                //如果找到了比中轴大的值
                if (l < emptyIndex) {
                    arr[emptyIndex] = arr[l];
                    emptyIndex = l;
                }


                //从右向左找，不能越界，找比中轴小的值
                while (emptyIndex < r && pivot < arr[r]) {
                    r--;
                }
                //如果找到了比中轴小的值
                if (emptyIndex < r) {
                    arr[emptyIndex] = arr[r];
                    emptyIndex = r;
                }


            }
            arr[emptyIndex] = pivot;

            //对中轴左边的进行排序
            quickSort(arr, left, emptyIndex - 1);

            //对中轴右边的进行排序
            quickSort(arr, emptyIndex + 1, right);
        }

    }
}
