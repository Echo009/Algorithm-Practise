package cn.echo0.algorithm.sequence;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/03/2017 03:34 PM
 */
public class UglyNumber {
    static int getNthUglyNumber(int bound) {
        if (bound <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[bound];
//        init
        uglyNumbers[0] = 1;

        int index2, index3, index5;
        index2 = index3 = index5 = 0;
        for (int i = 1; i < bound; i++) {
            int min = min(uglyNumbers[index2] * 2, uglyNumbers[index3] * 3, uglyNumbers[index5] * 5);
            uglyNumbers[i] = min;
            while (uglyNumbers[index2] * 2 <= min) {
                ++index2;
            }
            while (uglyNumbers[index3] * 3 <= min) {
                ++index3;
            }
            while (uglyNumbers[index5] * 5 <= min) {
                ++index5;
            }

        }
        return uglyNumbers[bound - 1];
    }

    private static int min(int a, int b, int c) {
        int min = a < b ? a : b;
        min = min < c ? min : c;
        return min;

    }

    public static void main(String[] args) {
        System.out.println(getNthUglyNumber(3));
    }
}
