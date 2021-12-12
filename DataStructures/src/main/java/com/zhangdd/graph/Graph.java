package com.zhangdd.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangdd on 2021/12/11
 */
public class Graph {

    private final List<String> vertexList = new ArrayList<>();

    private final int[][] edges;

    public Graph(int n) {
        edges = new int[n][n];
    }

    //region====图的常规维护==start

    /**
     * 添加节点
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加图的边，这里使用邻接矩阵来实现图的存储。所以通过 {@param rowIndex,@param colIndex}
     * 可以确定一个两个顶点之间的关系
     * <p>
     * 目前是无向图所以需要同时设置 edges[rowIndex][colIndex] 和 edges[colIndex][rowIndex]
     *
     * @param rowIndex 横坐标顶点的数组下标
     * @param colIndex 纵坐标顶点的数组下标
     * @param signal   两个顶点之间的关系 0表示不可达，1表示可达
     */
    public void insertEdge(int rowIndex, int colIndex, int signal) {
        edges[rowIndex][colIndex] = signal;
        edges[colIndex][rowIndex] = signal;
    }

    //endregion=图的常规维护==end

    //region====深度优先遍历==start
    public void dfs() {
        boolean[] visited = new boolean[vertexList.size()];
        vertexList.forEach(item -> {
            int vertexIndex = vertexList.indexOf(item);
            if (!visited[vertexIndex]) {
                dfs(visited, vertexIndex);
            }
        });
    }

    private void dfs(boolean[] visited, int vertexIndex) {
        System.out.print(vertexList.get(vertexIndex).concat("->"));
        visited[vertexIndex] = true;


        int neighborIndex = getFirstNeighbor(vertexIndex);
        while (-1 != neighborIndex) {
            if (!visited[neighborIndex]) {
                dfs(visited, neighborIndex);
            }

            //如果节点已经被访问过了，获取当前节点的下一个邻接节点
            neighborIndex = getNextNeighbor(vertexIndex, neighborIndex);
        }
    }

    /**
     * 获取指定节点的第一个邻接节点，如果不存在，则返回-1
     */
    private int getFirstNeighbor(int vertexIndex) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[vertexIndex][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取指定节点的下一个邻接节点，如果不存在，则返回-1
     *
     * @param vertexIndex   指定节点的索引下标
     * @param neighborIndex 节点的邻接节点的索引下标
     */
    private int getNextNeighbor(int vertexIndex, int neighborIndex) {
        for (int i = neighborIndex + 1; i < edges.length; i++) {
            if (edges[vertexIndex][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //endregion=深度优先遍历==end


    public void show() {
        Arrays.stream(edges)
                .forEach(item -> System.out.println(Arrays.toString(item)));
    }
}
