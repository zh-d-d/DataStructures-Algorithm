package com.zhangdd.sparsearray;

/**
 * @author zhangdd on 2021/9/22
 */
public class SparseArray {

    public static void main(String[] args) {
        //1.定义二维数组，并设置二维数组中有的数据
        int chessData[][] = new int[11][11];
        chessData[1][2] = 1;
        chessData[2][3] = 2;
        chessData[4][3] = 1;

        //2.记录有效值的个数
        int effectiveNumber = 0;
        for (int i = 0; i < chessData.length; i++) {
            for (int j = 0; j < chessData[i].length; j++) {
                int data = chessData[i][j];
                System.out.printf("%d\t", data);
                if (data != 0) {
                    effectiveNumber++;
                }
            }
            System.out.println();
        }

        //3.创建稀疏数组
        int sparseArray[][] = new int[effectiveNumber + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = effectiveNumber;

        //4.为稀疏数组赋值
        int record = 0;
        for (int i = 0; i < chessData.length; i++) {
            for (int j = 0; j < chessData[i].length; j++) {
                int data = chessData[i][j];
                if (data != 0) {
                    record++;
                    sparseArray[record][0] = i;
                    sparseArray[record][1] = j;
                    sparseArray[record][2] = chessData[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t,%d\t,%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        //5.将稀疏数组恢复为原来数组
        int newChess[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        //6.为原始数组填充数据
        for (int i = 1; i < sparseArray.length; i++) {
            newChess[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int i = 0; i < newChess.length; i++) {
            for (int j = 0; j < newChess[i].length; j++) {
                int data = chessData[i][j];
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
