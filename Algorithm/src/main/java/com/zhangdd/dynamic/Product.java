package com.zhangdd.dynamic;

/**
 * @author zhangdd on 2021/12/14
 */
public class Product {
    private final Integer value;

    private final Integer weight;

    private final String name;

    public Product(int value, int weight,String name) {
        this.value = value;
        this.weight = weight;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}
