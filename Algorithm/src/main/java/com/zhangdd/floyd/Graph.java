package com.zhangdd.floyd;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/12/25
 */
public class Graph {

    private final char[] vertices;
    private final int[][] matrix;

    public Graph(char[] vertices, int[][] matrix) {
        this.vertices = vertices;
        this.matrix = matrix;
    }

    public void floyd() {

        int[][] dis = matrix;

        //中间顶点
        for (int k = 0; k < vertices.length; k++) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int tmpLen = matrix[i][k] + matrix[k][j];
                    if (tmpLen < matrix[i][j]) {
                        dis[i][j] = tmpLen;
                    }
                }
            }
        }
        for (int[] i : dis) {
            System.out.print(Arrays.toString(i));
            System.out.println();
        }

    }
}
