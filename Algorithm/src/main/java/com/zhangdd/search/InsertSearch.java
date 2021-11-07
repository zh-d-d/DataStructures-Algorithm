package com.zhangdd.search;

/**
 * 插值查找
 *
 * @author zhangdd on 2021/11/7
 */
public class InsertSearch {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 8, 8, 10, 18};

        int searchIndex = insertSearch(arr, 0, arr.length - 1, 3);
        System.out.println(searchIndex);
    }

    private static int insertSearch(int[] arr, int left, int right, int findVal) {
        //1.当left>right说明对数列遍历完了，也没找到
        //2.如果arr[left] > findVal 说明，当前数列的最小值都比要查找的数值大，说明要查找的数值不再数列中
        //3.如果arr[right] < findVal 说明，当前数列的最大值都比要查找的数值小，说明要查找的数值不再数列中
        if (left > right || arr[left] > findVal || arr[right] < findVal) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right - arr[left]]);
        int midValue = arr[mid];
        if (findVal > midValue) {
            return insertSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midValue) {
            return insertSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
