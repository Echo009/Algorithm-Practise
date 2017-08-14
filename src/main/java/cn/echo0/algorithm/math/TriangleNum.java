package cn.echo0.algorithm.math;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/14/2017 04:24 PM
 */
public class TriangleNum {
    //m*n的棋盘中的矩形个数，考虑边的组合即可
    public static int countNumOfTriangle(int m, int n) {
        return ((n + 1) * n >> 1) * ((m + 1) * m >> 1);
    }

    public static void main(String[] args) {
        System.out.println(countNumOfTriangle(2, 9));
    }
}
