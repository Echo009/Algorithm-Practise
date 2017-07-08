/*
 * Author : Echo0 
 * Email  : ech0.extreme@foxmail.com
 * Time   : Jun 28, 2017 3:08:58 PM
 */
package cn.echo0.algorithm.array;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Ech0
 */
public class FindRepetitiveNumberInArray {
//    在一个长度为N的数组里面的所有数字都在0~n-1之间。
//    数组中某些数字是重复的，但不知道有几个数字重复了，
//    也不知道每个数字重复了几次。请找出数组中任意的一个重复数字。

    public static int findRepetitiveNumber(int[] intArray) {
        int length = intArray.length;
        for (int i = 0; i < length; i++) {

            while (intArray[i] != i) {
                if (intArray[i] == intArray[intArray[i]]) {
                    return intArray[i];
                }
                // swap  intArray[i] and intArray[intArray[i]]
                int temp = intArray[i];
                intArray[i] = intArray[temp];
                intArray[temp] = temp;
            }
        }
        return -1;  // not found 
    }
//    在题1的要求上增加不修改原数组的条件。
//    0~n-1  length = n 
//    二分查找

    public static int findRepetitiveNumberNoModified(int[] intArray) {
        int length = intArray.length;
        int start = 0;
        int end = length - 1;
        int middle;
        while (end >= start) {
            middle = (start + end) >> 1;
            int count = countRange(intArray, start, middle);
            if (end == start) {
                if (count > 0) {
                    return end;
                } else {
                    break;
                }
            }
            if (count > middle - start + 1) {//说明这个区间内的数字存在有重复的，缩小范围
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
    public static int countRange(int[] intArray, int start, int end) {
        int count = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] >= start && intArray[i] <= end) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] intArray = new Random().ints(0, 21).limit(21).toArray();
        Arrays.stream(intArray).forEach(e -> System.out.print(" " + e));
        System.out.println("");
        System.out.println(findRepetitiveNumber(intArray));
        System.out.println("");
        System.out.println(findRepetitiveNumberNoModified(intArray));
    }
}
