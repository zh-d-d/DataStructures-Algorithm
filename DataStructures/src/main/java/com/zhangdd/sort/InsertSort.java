package com.zhangdd.sort;

/**
 * @author zhangdd on 2021/10/30
 */
public class InsertSort {

    public static void main(String[] args) {
        //从小到大排
        int[] arr = {1, 9, 7, -3, 2};

        //从j=1开始
        for (int j = 1; j < arr.length; j++) {
            int readyIndex = j;
            int readyValue = arr[j];//暂存开始时索引的值，下面的循环是为其寻找合适位置
            for (int i = j - 1; i >= 0; i--) {
                if (arr[i] > readyValue) {
                    arr[i + 1] = arr[i];
                    readyIndex--;
                } else {
                    break;
                }
            }
            //找到合适的下标位置，设置值
            arr[readyIndex] = readyValue;
        }

        for (int j : arr) {
            System.out.printf("%d ", j);
        }
    }
}
