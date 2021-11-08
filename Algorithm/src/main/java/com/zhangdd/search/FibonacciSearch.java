package com.zhangdd.search;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/11/7
 */
public class FibonacciSearch {

    /**
     * 斐波那契队列长度
     */
    private static int maxLength = 20;

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 5, 8, 8, 10, 18};

        int searchIndex = fibonacciSearch(arr, 3);
        System.out.println(searchIndex);
    }


    /**
     * 构造一个斐波那契队列
     */
    private static int[] buildFibonacciArr() {
        int first = 1;
        int second = 1;
        int[] result = new int[maxLength];
        result[0] = first;
        result[1] = second;

        for (int i = 2; i < maxLength; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result;
    }

    private static int fibonacciSearch(int[] arr, int findVal) {

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        int arrSize = arr.length;
        int[] fibonacciArr = buildFibonacciArr();
        int fibonacciArrIndex = 0;
        while (arrSize > fibonacciArr[fibonacciArrIndex]) {
            fibonacciArrIndex++;
        }
        int[] temp = Arrays.copyOf(arr, fibonacciArr[fibonacciArrIndex]);
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[arrSize - 1];
        }

        while (left <= right) {
            mid = left + fibonacciArr[fibonacciArrIndex - 1] - 1;

            if (findVal < temp[mid]) {
                right = mid - 1;
                fibonacciArrIndex--;
            } else if (findVal > temp[mid]) {
                left = mid + 1;
                fibonacciArrIndex -= 2;
            } else {

                //这里找到了，返回较小的一个下标
                return Math.min(mid, right);
            }

        }

        return -1;
    }
}
