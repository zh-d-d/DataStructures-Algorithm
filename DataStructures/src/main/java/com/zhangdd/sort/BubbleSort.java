package com.zhangdd.sort;

/**
 * @author zhangdd on 2021/10/19
 */
public class BubbleSort {

    public static void main(String[] args) {
        //从小到大排
        int[] arr = {1, 9, 7, -3, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            int temp;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int j : arr) {
            System.out.printf("%d ", j);
        }
    }
}
