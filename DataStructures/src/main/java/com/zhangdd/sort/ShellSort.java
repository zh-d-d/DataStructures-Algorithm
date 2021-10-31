package com.zhangdd.sort;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/10/30
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

//        analyseProcess(arr);


//        swap(arr);


        move(arr);

    }

    /**
     * 使用移动完成希尔排序
     */
    private static void move(int[] arr) {
        for (int step = arr.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < arr.length; i++) {

                int readyValue = arr[i];
                int readyIndex = i;
                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > readyValue) {
                        arr[j + step] = arr[j];
                        readyIndex -= step;
                    } else {
                        break;
                    }
                }
                arr[readyIndex] = readyValue;
            }
        }

        System.out.println("排序结果" + Arrays.toString(arr));

    }


    /**
     * 使用交换完成希尔排序
     */
    private static void swap(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {

            for (int i = step; i < arr.length; i++) {

                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        int temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
        }


        System.out.println("排序结果" + Arrays.toString(arr));
    }

    /**
     * 分析排序过程
     */
    private static void analyseProcess(int[] arr) {
        //第一轮排序 这是一个简单排序==> 第一轮排序结果[3, 5, 1, 6, 0, 8, 9, 4, 7, 2]
        for (int i = 5; i < arr.length; i++) {

            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println("第一轮排序结果" + Arrays.toString(arr));


        //第二轮排序 这是一个简单排序==> 第二轮排序结果[0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
        for (int i = 2; i < arr.length; i++) {

            for (int j = i - 2; j >= 0; j -= 2) {

                if (arr[j] > arr[j + 2]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        System.out.println("第二轮排序结果" + Arrays.toString(arr));

        //第三轮排序 这是一个简单排序==> 第三轮排序结果[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        for (int i = 1; i < arr.length; i++) {

            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("第三轮排序结果" + Arrays.toString(arr));
    }


}
