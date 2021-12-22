package com.zhangdd.prim;

/**
 * @author zhangdd on 2021/12/20
 */
public class Graph {


    private int[][] matrix;

    private char[] vertex;

    private final int vertexSize;

    public Graph(int vertexSize,char[]vertex,int [][]matrix) {
        this.vertexSize = vertexSize;

       this.matrix = matrix;
        this.vertex = vertex;
    }

    public int getVertexSize() {
        return vertexSize;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public char[] getVertex() {
        return vertex;
    }

    public void setVertex(char[] vertex) {
        this.vertex = vertex;
    }
}
