package com.zhangdd.search;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二分查找
 *
 * @author zhangdd on 2021/11/7
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 8, 8, 10, 18};
        int searchResultIndex = binarySearch(arr, 0, arr.length - 1, 8);
        System.out.println(searchResultIndex);

        List<Integer> integers = binarySearchMul(arr, 0, arr.length - 1, 7);
        System.out.println(integers);

    }

    private static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }

        int mid = Math.addExact(left, right) / 2;
        int midValue = arr[mid];
        if (findVal > midValue) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midValue) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }

    private static List<Integer> binarySearchMul(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return Collections.emptyList();
        }

        int mid = Math.addExact(left, right) / 2;
        int midValue = arr[mid];
        if (findVal > midValue) {
            return binarySearchMul(arr, mid + 1, right, findVal);
        } else if (findVal < midValue) {
            return binarySearchMul(arr, left, mid - 1, findVal);
        } else {
            List<Integer> result = new ArrayList<>();
            int tempIndex = mid - 1;

            while (tempIndex >= 0 && findVal == arr[tempIndex]) {

                result.add(tempIndex);
                tempIndex -= 1;
            }

            result.add(mid);

            tempIndex = mid + 1;
            while (tempIndex <= arr.length && findVal == arr[tempIndex]) {

                result.add(tempIndex);
                tempIndex += 1;
            }

            return result;

        }

    }
}
