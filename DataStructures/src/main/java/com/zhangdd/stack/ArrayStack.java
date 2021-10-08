package com.zhangdd.stack;

/**
 * @author zhangdd on 2021/10/8
 */
public class ArrayStack {

    private final int maxSize;
    private final int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    private boolean isFull() {
        return top == maxSize - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("当前栈已经满了");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("当前栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("当前栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
