package com.zhangdd.recusion;

import org.junit.Test;

/**
 * 递归-迷宫问题
 * <p>
 * 一个8X7大小的迷宫，每个方格如果是1 表示是拦截物，
 * 约定方格中如果是2表示可以走，如果是3表示走过，但是通过该方格走不通
 * 按照下->右->上->左的顺序进行尝试走
 *
 * @author zhangdd on 2021/10/12
 */
public class MiGong {


    @Test
    public void findRole() {
        //初始化地图，并设置初始障碍信息
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("初始地图信息");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        doFindRode(map, 1, 1);

        System.out.println("寻路之后地图信息");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 找可以走的节点，将其标识为2
     */
    private boolean doFindRode(int[][] map, int startX, int startY) {
        if (map[6][5] == 2) {
            return true;
        }
        int curValue = map[startX][startY];
        if (curValue == 0) {
            map[startX][startY] = 2;
            if (doFindRode(map, startX + 1, startY)) {//向下走，且可以走 那么当前的节点可以标记为正确的
                return true;
            } else if (doFindRode(map, startX, startY + 1)) {
                return true;
            } else if (doFindRode(map, startX - 1, startY)) {
                return true;
            } else if (doFindRode(map, startX, startY - 1)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }


}
