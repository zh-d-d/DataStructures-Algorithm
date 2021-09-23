package com.zhangdd.queue;

/**
 * @author zhangdd on 2021/9/23
 */
public class ArrayQueue {

    //表示数组最大容量
    private final int maxSize;

    //队列头
    private int front = -1;

    //队列尾
    private int rear = -1;

    //存放数据的队列
    private final int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    private boolean isFull() {
        return rear == maxSize - 1;
    }

    private boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("当前队列已满，不能添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空，没有数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("当前队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空，没有数据");
        }
        return arr[front + 1];
    }

}
