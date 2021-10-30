package com.zhangdd.sort;

/**
 * @author zhangdd on 2021/10/30
 */
public class BubbleSortImprove {

    public static void main(String[] args) {
        //从小到大排
        int[] arr = {1, 9, 7, -3, 2};

        for (int i = 0; i < arr.length - 1; i++) {

            int temp;
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }


        for (int j : arr) {
            System.out.printf("%d ", j);
        }
    }
}
