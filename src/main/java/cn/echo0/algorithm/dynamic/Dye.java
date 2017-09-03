package cn.echo0.algorithm.dynamic;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/23/2017 09:15 AM
 */
public class Dye {
    /*
 * @param n: non-negative integer, n posts
 * @param k: non-negative integer, k colors
 * @return: an integer, the total number of ways
 */
    public static int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        }

        int[] result = new int[n];
        result[0] = k;
        result[1] = k * k;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] * (k - 1) + result[i - 2] * (k - 1);
        }
        return result[n - 1];

    }

    public static void main(String[] args) {
        System.out.println(numWays(3, 2));
    }
}
