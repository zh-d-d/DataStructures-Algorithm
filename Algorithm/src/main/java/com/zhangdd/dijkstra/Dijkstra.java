package com.zhangdd.dijkstra;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/12/25
 */
public class Dijkstra {

    private final char[] vertex;
    private final int[][] matrix;

    /**
     * 标识各个顶点是否访问过，访问过表示1，未访问过表示0
     */
    private final int[] visitedArr;

    /**
     * 从出发顶点到其他顶点的距离，比如从G出发，就是从G到其他各个顶点的距离
     */
    private final int[] dis;

    public Dijkstra(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;

        this.visitedArr = new int[vertex.length];
        this.dis = new int[vertex.length];

        Arrays.fill(dis, Integer.MAX_VALUE);

    }

    public void dsj(int index) {
        //标记起始顶点被访问过
        this.visitedArr[index] = 1;
        this.dis[index] = 0;

        update(index);

        for (int i = 1; i < vertex.length; i++) {
            index = updateStartIndex();
            update(index);
        }

    }

    /**
     * 获取新的访问顶点，比如访问完G之后，A是下一个新的访问顶点
     */
    private int updateStartIndex() {
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < visitedArr.length; i++) {
            if (visitedArr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }

        visitedArr[index] = 1;
        return index;
    }

    /**
     * 更新index下标到周围其他顶点的距离和周围顶点的前驱顶点
     */
    private void update(int index) {
        int len = 0;
        for (int i = 0; i < this.matrix[index].length; i++) {
            //从出发顶点到index顶点的距离+从index顶点到i顶点距离的和
            len = dis[index] + matrix[index][i];
            //如果这个顶点没有访问过 且 len小于出发顶点到i顶点的距离，就需要更新
            if (visitedArr[i] != 1 && len < dis[i]) {
                updateDis(i, len);
            }
        }
    }



    /**
     * 更新出发点到顶点的距离
     *
     * @param vertexIndex 顶点的下标
     * @param distance    距离
     */
    private void updateDis(int vertexIndex, int distance) {
        dis[vertexIndex] = distance;
    }

    public void showDijkstra() {

        int count = 0;
        for (int i : dis) {
            if (i != Integer.MAX_VALUE) {
                System.out.print(vertex[count] + "(" + i + ")");
            } else {
                System.out.println("N");
            }
            count++;
        }
    }
}
