package com.zhangdd.dynamic;

/**
 * @author zhangdd on 2021/12/14
 */
public class Product {
    private final Integer value;

    private final Integer weight;

    public Product(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}
