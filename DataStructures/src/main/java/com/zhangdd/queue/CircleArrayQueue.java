package com.zhangdd.queue;

/**
 * //注意这里实现的环形队列，是空了一个空间，所以创建的大小为4时实际可以存放的数据个数是3个
 *
 * @author zhangdd on 2021/9/25
 */
public class CircleArrayQueue {

    private int front = 0;
    private int rear = 0;
    private final int[] arr;
    private final int maxSize;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    private boolean isEmpty() {
        return rear == front;
    }


    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("当前队列已满，不能添加输入");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列空，没有数据");
        }
        int data = arr[front];
        front = (front + 1) % maxSize;
        return data;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列空，没有数据");
        }
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("当前队列空，没有数据");
            return;
        }
        int valueNumber = (rear - front + maxSize) % maxSize;
        for (int i = front, index = 0; index < valueNumber; i = (i + 1) % maxSize, index++) {
            System.out.printf("arr[%d]=%d\t", i, arr[i]);
        }
        System.out.println();
    }
}
