package com.zhangdd.prim;

/**
 * @author zhangdd on 2021/12/21
 */
public class PrimExample {

    public static void main(String[] args) {
        int[][] matrix = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        Graph graph = new Graph(data.length, data, matrix);

        MinTree minTree=new MinTree();


        minTree.prim(graph,0);

    }
}
