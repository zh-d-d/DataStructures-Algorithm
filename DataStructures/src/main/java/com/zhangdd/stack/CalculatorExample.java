package com.zhangdd.stack;

import org.junit.Test;

/**
 * @author zhangdd on 2021/10/10
 */
public class CalculatorExample {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("3+2*6-100"));
    }

    @Test
    public void calculatorStackTest() {
        Calculator.ArrayStack stack = new Calculator.ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
