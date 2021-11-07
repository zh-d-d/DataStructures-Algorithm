package com.zhangdd.search;

/**
 * 线性查找
 *
 * @author zhangdd on 2021/11/7
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 8, 4, 3};

        int searchIndex = seqSearch(arr, 10);
        System.out.println(searchIndex);
    }

    private static int seqSearch(int[] arr, int findVal) {
        for (int i = 0; i < arr.length; i++) {
            if (findVal == arr[i]) {
                return i;
            }
        }

        return -1;
    }
}
