package com.zhangdd.prim;

/**
 * @author zhangdd on 2021/12/21
 */
public class MinTree {

    public void prim(Graph graph, int index) {
        int[][] matrix = graph.getMatrix();
        char[] vertex = graph.getVertex();

        //是否访问过
        int[] visited = new int[graph.getVertexSize()];
        //存储访问过的节点的下标，随着遍历 子图的节点越来越多
        int[] queue = new int[graph.getVertexSize()];

        //第一个被访问的节点
        visited[index] = 1;

        int count = 0;
        queue[count] = index;
        count++;


        while (count < graph.getVertexSize()) {
            int min = Integer.MAX_VALUE;
            int tmpIndex = 0;

            for (int i = 0; i < count; i++) {
                for (int j = 0; j < matrix[queue[i]].length; j++) {
                    if (visited[j] == 0 && matrix[queue[i]][j] < min) {
                        min = matrix[queue[i]][j];
                        tmpIndex = j;
                    }
                }
            }
            visited[tmpIndex] = 1;
            queue[count] = tmpIndex;
            count++;
        }

        for (int j : queue) {
            System.out.println(vertex[j]);
        }

    }
}
