package com.zhangdd.graph;

import java.util.Arrays;

/**
 * @author zhangdd on 2021/12/11
 */
public class GraphExample {

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        String[] vertex = {"A", "B", "C", "D", "E"};
        Arrays.stream(vertex).forEach(graph::insertVertex);

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);

        graph.insertEdge(1, 0, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.insertEdge(2, 0, 1);
        graph.insertEdge(2, 1, 1);

        graph.insertEdge(3, 1, 1);

        graph.insertEdge(4, 1, 1);

        graph.show();

        graph.dfs();

        System.out.println("图的广度优先遍历");

        graph.bfs();

    }
}
