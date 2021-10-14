package com.zhangdd.recusion;

import org.junit.Test;

/**
 * @author zhangdd on 2021/10/14
 */
public class Queue8 {

    final int MAX = 8;
    int[] arr = new int[MAX];
    int solutionCount = 0;


    @Test
    public void findSolution() {
        doPoint(0);
        System.out.printf("一个有%d中解法", solutionCount);
    }


    /**
     * 判断第n个皇后位置是否合法
     * <p>
     * 即判断和前n-1个是否在同一行、同一列、同一斜线
     */
    private boolean illegal(int n) {
        for (int i = 0; i < n; i++) {
            //(i,arr[i])  (n,arr[n])
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 放第n个皇后
     */
    private void doPoint(int n) {
        if (n == MAX) {
            showSolution();
            return;
        }
        for (int i = 0; i < MAX; i++) {
            arr[n] = i;
            if (illegal(n)) {
                doPoint(n + 1);
            }
        }
    }

    /**
     * 展示当前解法
     */
    private void showSolution() {
        solutionCount++;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
