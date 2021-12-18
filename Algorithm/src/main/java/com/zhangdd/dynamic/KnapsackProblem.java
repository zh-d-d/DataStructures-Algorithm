package com.zhangdd.dynamic;

import java.util.List;

/**
 * @author zhangdd on 2021/12/14
 */
public class KnapsackProblem {

    private final int capacity;
    private final List<Product> products;

    private final int[] values;
    private final int[] weights;

    private final int[][] maxValue;

    private final int[][] path;

    public KnapsackProblem(int capacity, List<Product> products) {
        this.capacity = capacity;
        this.products = products;
        values = new int[products.size()];
        weights = new int[products.size()];
        for (int i = 0; i < products.size(); i++) {
            values[i] = products.get(i).getValue();
            weights[i] = products.get(i).getWeight();
        }

        maxValue = new int[products.size() + 1][capacity + 1];
        path = new int[products.size() + 1][capacity + 1];
    }

    public int maxValue() {

        for (int i = 1; i <= products.size(); i++) {

            for (int j = 1; j <= capacity; j++) {
                //当前物品的重量大于当前背包的容量j ,即装不下当前物品。同时这个物品也就不会选择不用放到path里
                if (weights[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
//                    maxValue[i][j] = Math.max(maxValue[i - 1][j], values[i - 1] + maxValue[i - 1][j - weights[i - 1]]);
                    //为了记录path，这里使用if-else判断
                    if (maxValue[i - 1][j] < (values[i - 1] + maxValue[i - 1][j - weights[i - 1]])) {
                        maxValue[i][j] = values[i - 1] + maxValue[i - 1][j - weights[i - 1]];
                        path[i][j] = 1;
                    } else {
                        //这个条件说明这个物品也就不会选择，即不用放到path里
                        maxValue[i][j] = maxValue[i - 1][j];
                    }
                }

            }
        }

        return maxValue[products.size()][capacity];
    }

    public void showPath() {
        //使用path 倒序，遍历其值为1下标，然后获取对应商品信息
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("选择了商品" + products.get(i - 1).getName());
                j = j - weights[i - 1];
            }
            i--;
        }

    }
}
