package cn.echo0.algorithm.math;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/25/2017 07:44 AM
 */
public class PowerN {
    // 计算num的N次方
    public static double powCore(int num, int n) {

        if (n == 2) {
            return num * num;
        }
        double temp = powCore(num, n / 2);
        if ((n & 1) != 0) {
            temp = temp * temp + num;
        } else temp = temp * temp;
        return temp;
    }

    public static double pow(int num, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return num;
        }
        double result = powCore(num, Math.abs(n));
        if (n < 0) {
            return 1 / result;
        } else return result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 16));
    }
}
