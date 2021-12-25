package com.zhangdd.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangdd on 2021/12/25
 */
public class HorseChessboard {

    //棋盘的列数
    private final int X;
    //棋盘的行数
    private final int Y;

    private final boolean[] visitState;

    private final int[][] chessboard;

    private boolean finished;

    public HorseChessboard(int x, int y) {
        X = x;
        Y = y;

        chessboard = new int[x][y];
        visitState = new boolean[x * y];
    }

    public void startMove(int row, int column) {
        startMove(row, column, 1);
        show();
    }

    private void startMove(int row, int column, int step) {

        chessboard[row][column] = step;
        visitState[X * row + column] = true;

        List<Point> points = nextPoints(new Point(column, row));
        //使用贪心算法进行优化
        sort(points);
        while (!points.isEmpty()) {
            Point point = points.remove(0);
            if (!visitState[point.y * X + point.x]) {
                startMove(point.y, point.x, step + 1);
            }
        }
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visitState[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    private void sort(List<Point> points) {
        points.sort(Comparator
                .comparingInt(o -> nextPoints(o).size()));
    }


    private void show() {
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 获取当前位置接下来还可以走的位置
     */
    private List<Point> nextPoints(Point curPoint) {
        List<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

}
