package com.zhangdd.tree;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/11/27
 */
public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};

        headSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    public static void headSort(int arr[]) {

        //第一步，调整成一个大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        int temp;

        //第二步，将堆顶元素和末尾元素交换
        //第三步，重新调整结构，使其满足堆定义
        for (int i = arr.length - 1; i > 0; i--) {
            //交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 将数组调整成大顶堆。将下标元素为i的子树调整成大顶堆
     *
     * @param arr    数组
     * @param index  非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整
     */
    private static void adjustHeap(int arr[], int index, int length) {

        int temp = arr[index];

        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            //判断index节点的左右节点哪个子节点大
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            //判断index节点和其较大的子节点哪个大
            if (temp < arr[i]) {
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        arr[index] = temp;
    }


}
