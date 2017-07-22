package cn.echo0.algorithm.array;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/22/2017 03:07 PM
 */
public class AdjustPosition {
    //给定一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
    public static void adjustPostion(int[] intArray) {
        if (intArray == null || intArray.length == 0) {
            return;
        }
        int perIndex = 0;
        int backIndex = intArray.length - 1;
        while (perIndex < backIndex) {
            while (perIndex < backIndex && (intArray[perIndex] & 1) != 0) {
                perIndex++;
            }
            while (backIndex > perIndex && (intArray[backIndex] & 1) == 0) {
                backIndex--;
            }
            if (backIndex > perIndex) {
                //swap
                intArray[perIndex] ^= intArray[backIndex];
                intArray[backIndex] ^= intArray[perIndex];
                intArray[perIndex] ^= intArray[backIndex];
            }
        }
    }

    public static void main(String[] args) {
        int[] intArray = {1,4,5,6,8,9,0,3,2,7};
        adjustPostion(intArray);
        System.out.println(Arrays.toString(intArray));


    }
}
