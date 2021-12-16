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
    }

    public int maxValue() {

        for (int i = 1; i <= products.size(); i++) {

            for (int j = 1; j <= capacity; j++) {
                //当前物品的重量大于当前背包的容量j ,即装不下当前物品
                if (weights[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    maxValue[i][j] = Math.max(maxValue[i - 1][j], values[i - 1] + maxValue[i - 1][j - weights[i - 1]]);
                }

            }
        }

        return maxValue[products.size()][capacity];
    }
}
