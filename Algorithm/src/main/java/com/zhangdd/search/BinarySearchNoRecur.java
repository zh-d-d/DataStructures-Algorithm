package com.zhangdd.search;

/**
 * @author zhangdd on 2021/12/13
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8, 8, 10, 18};
        int index = binarySearchNoRecur(arr, 18);

        System.out.println(index);
    }

    private static int binarySearchNoRecur(int[] arr, int targetValue) {
        int left = 0;
        int right = arr.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (targetValue == arr[middle]) {
                return middle;
            } else if (targetValue < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
