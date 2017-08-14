package cn.echo0.algorithm.array;

import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/24/2017 07:56 PM
 */
public class ProtectScheme {
    //保卫方案
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        int i = 0;
        int mountains[] = new int[numCount];
        for (; i < numCount; i++) {
            mountains[i] = scanner.nextInt();
        }
    }

    public static int countPair(int[] mountains) {
        int length = mountains.length;
        int sum = length;

        for (int i = 0; i < length; i++) {
            //TODO
        }
        return sum;
    }

}
