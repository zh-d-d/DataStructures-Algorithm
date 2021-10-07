package com.zhangdd.linkedlist;

import org.junit.Test;

/**
 * @author zhangdd on 2021/10/7
 */
public class JosephusExample {

    @Test
    public void initJosephusCircleTest() {
        Josephus josephus = new Josephus();
        josephus.initCircle(5);

        josephus.showCircle();
    }

    @Test
    public void playJosephusTest() {
        Josephus josephus = new Josephus();
        josephus.initCircle(5);

        josephus.play(1, 3);
    }
}
