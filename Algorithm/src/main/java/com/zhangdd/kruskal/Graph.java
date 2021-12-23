package com.zhangdd.kruskal;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/12/23
 */
public class Graph {

    private final char[] vertices;

    private final int matrix[][];

    private final int edgeNum;

    private final Edge[] edges;


    public Graph(char[] vertices, int[][] matrix) {
        this.vertices = vertices;
        this.matrix = matrix;

        //统计图中边的个数
        int edgeCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    edgeCount++;
                }
            }
        }

        edgeNum = edgeCount;
        edges = new Edge[edgeNum];

        int edgeIndex=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    edges[edgeIndex++] = new Edge(vertices[i], vertices[j], matrix[i][j]);
                }
            }
        }
    }

    public void kruskal() {
        sort();
        int[] ends = new int[edgeNum];

        int index = 0;
        Edge[] result = new Edge[vertices.length-1];

        for (Edge edge : edges) {
            int curEdgeStart = getVertexIndex(edge.start);
            int curEdgeEnd = getVertexIndex(edge.end);

            int startEndIndex = getEndIndex(ends, curEdgeStart);
            int endEndIndex = getEndIndex(ends, curEdgeEnd);

            if (startEndIndex != endEndIndex) {
                ends[startEndIndex] = endEndIndex;
                result[index++] = edge;
            }
        }

        Arrays.stream(result).forEach(System.out::println);
    }

    /**
     * 获取顶点的终点索引
     *
     * @param ends        记录各个顶点终点的数组
     * @param vertexIndex 顶点的下标索引
     */
    private int getEndIndex(int[] ends, int vertexIndex) {
        while (ends[vertexIndex] != 0) {
            vertexIndex = ends[vertexIndex];
        }
        return vertexIndex;
    }


    /**
     * 获取顶点的索引下标
     */
    private int getVertexIndex(char vertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == vertex) {
                return i;
            }
        }

        return -1;
    }


    /**
     * 对边进行冒泡排序
     */
    private void sort() {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }


    public static class Edge {
        private final char start;
        private final char end;
        private final int weight;

        public Edge(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }
}
