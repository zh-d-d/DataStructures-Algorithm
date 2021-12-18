package com.zhangdd.dynamic;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/12/14
 */
public class KnapsackProblemExample {

    public static void main(String[] args) {
        Product p1 = new Product(1500, 1, "吉他");
        Product p2 = new Product(3000, 4, "音响");
        Product p3 = new Product(2000, 3, "电脑");

        KnapsackProblem knapsack = new KnapsackProblem(4, Arrays.asList(p1, p2, p3));

        int value = knapsack.maxValue();

        System.out.println(value);

        knapsack.showPath();

    }
}
