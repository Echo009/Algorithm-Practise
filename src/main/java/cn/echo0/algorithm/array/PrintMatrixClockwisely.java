package cn.echo0.algorithm.array;

import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/25/2017 11:06 AM
 */
public class PrintMatrixClockwisely {
    public static void printMatrixClockwisely(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int columns = matrix[0].length;
        int rows = matrix.length;
        for (int i = 0; i * i < rows && i * i < columns; i++) {
            printMatrixInCircle(matrix, rows, columns, i);
        }
    }

    private static void printMatrixInCircle(int[][] matrix, int rows, int columns, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

//        从左到右打印一行
        for (int i = start; i <= endX; i++) {
            System.out.print(matrix[start][i]+" ");
        }
//        从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.print(matrix[i][endX]+" ");
            }
        }
//        从右至左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(matrix[endY][i]+" ");
            }
        }
//        从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; i--) {
                System.out.print(matrix[i][start]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][5];
        matrix[0] = new int[]{1, 2, 3, 4, 5};
        matrix[1] = new int[]{3, 7, 3, 6, 0};
        matrix[2] = new int[]{4, 5, 0, 7, 9};
        matrix[3] = new int[]{7, 8, 3, 4, 8};
        printMatrixClockwisely(matrix);

    }
}
