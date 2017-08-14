package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/13/2017 12:58 PM
 */


import java.util.Arrays;
import java.util.Scanner;

public class ChessSolutions {
    private static int x[];
    private static int y[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in
        );
        int n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
        }
        int[][] distance = new int[n * n][n];//distance[i][j] 枚举n*n个点到给定的n个点的距离
        for (int i = 0; i < n; i++) {
            int startIndex = i * n;
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {
                    distance[startIndex + j][k] = Math.abs(x[i] - x[k]) + Math.abs(y[j] - y[k]);
                }
            }
        }
        for (int i = 0; i < n * n; i++) {
            Arrays.sort(distance[i]);
        }
        int min[] = new int[n * n];
        for (int j = 0; j < n; j++) {
            int minMove = Integer.MAX_VALUE;
            for (int i = 0; i < n * n; i++) {
                min[i] += distance[i][j];
                if (min[i] < minMove) {
                    minMove = min[i];
                }
            }
            if (j == n - 1) {
                System.out.println(minMove);
                return;
            }
            System.out.print(minMove + " ");
        }

    }
}

