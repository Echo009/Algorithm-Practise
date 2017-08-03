package cn.echo0.algorithm.dynamic;

import java.util.Arrays;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/02/2017 06:50 PM
 */
public class MaxValueOfGifs {
    //    在一个m*n的棋盘的每一格都有放一个礼物，每一个礼物 都有一定的价值>0。
//    你可以从棋盘的左上角开始拿格子里的礼物，并且每次向左或者向下移动一格，直到到达棋盘的右下角为止 。
//    给定一个棋盘以及上面的礼物，请计算你最多能拿到多少价值的礼物？
//    maxValue(i,j) = max(maxValue(i-1,j),maxValue(i,j-1))+value(i,j)
    static int maxValueOfGifs(int[][] matrix) {
        if (matrix == null || matrix[0] == null || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] maxValue = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {//first row
                    if (j == 0) {
                        maxValue[i][j] = matrix[i][j];
                    } else
                        maxValue[i][j] = matrix[i][j] + maxValue[i][j - 1];
                } else {
                    if (j == 0) {//first col
                        maxValue[i][j] = matrix[i][j] + maxValue[i - 1][j];
                    } else
                        maxValue[i][j] = (maxValue[i - 1][j] > maxValue[i][j - 1] ? maxValue[i - 1][j] : maxValue[i][j - 1])+ matrix[i][j];
                }
            }

        }
        for (int[] array : maxValue) {
            System.out.println(Arrays.toString(array));

        }
        return maxValue[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int matrix[][] = new int[4][];
        matrix[0] = new int[]{1, 10, 3, 8};
        matrix[1] = new int[]{12, 3, 9, 6};
        matrix[2] = new int[]{5, 7, 4, 11};
        matrix[3] = new int[]{3, 7, 16, 5};
        System.out.println(maxValueOfGifs(matrix));
    }

}
