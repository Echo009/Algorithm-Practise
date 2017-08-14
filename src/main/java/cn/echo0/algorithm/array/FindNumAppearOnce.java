package cn.echo0.algorithm.array;

import java.util.Arrays;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/08/2017 10:24 AM
 */
public class FindNumAppearOnce {
    //    在给定数组中找到只出现一次的数字，其他数字都出现了三次
    public static int findNumAppearOnce(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] num = new int[32];
        for (int i = 0; i < array.length; i++) {
            int bitMask = 1;
            for (int j = 0; j < 32; j++) {
                if ((array[i] & bitMask) != 0) {
                    num[j]++;
                }
                bitMask = bitMask << 1;
            }
        }
        System.out.println(Arrays.toString(num));
        int result = 0;
        int bitMask = 1;
        for (int i = 0; i < 32; i++) {
            result += num[i] % 3 == 0 ? 0 : bitMask;
            bitMask = bitMask << 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 2, 3, 3, 3, -1, 4, 5, -1, 4, 5, 4, 5, -1, 0};
        System.out.println(findNumAppearOnce(array));
    }
}
