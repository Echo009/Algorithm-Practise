package cn.echo0.algorithm.array;

import cn.echo0.algorithm.common.Swap;

import java.util.Arrays;
import java.util.TreeSet;

import static cn.echo0.algorithm.common.GenArray.genIntArray;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/30/2017 08:00 PM
 */
public class FindLeastNumbers {
    //以数组中下标为k的元素基准，调整数组 ，返回调整过后基准数的下标
    private static int partition(int[] array, int k) {
        int pivot = array[k];
        Swap.swapIntArray(array, k - 1, 0);
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (end > start && array[end] > pivot) {
                end--;
            }
            if (end > start) {
                Swap.swapIntArray(array, start, end);
            }
            while (start < end && array[start] < pivot) {
                start++;
            }
            if (start > end) {
                Swap.swapIntArray(array, start, end);
            }
        }

        return start ;
    }

    //找到数组中最小的k个数
    static void printLeastNumbers(int[] array, int k) {
        if (array == null || array.length == 0 || k < 0 || k >= array.length) {
            return;
        }
        int position = partition(array, k-1);
        while (position != k-1) {
            position = partition(array, k-1);
        }
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //这里 ， 前提是前面的k个最小元素互不相同
    static void printLeastNumbersRecords(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            return;
        }
        int count = 0;
        TreeSet<Integer> records = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            if (count < k) {
                records.add(array[i]);
                count++;
            } else {
                if (records.last() > array[i]) {
                    records.pollLast();
                    records.add(array[i]);
                }
            }
        }
        System.out.println(Arrays.toString(records.toArray()));
    }

    public static void main(String[] args) {
        int[] array = genIntArray(20);
        System.out.println(Arrays.toString(array));
        printLeastNumbersRecords(array, 4);
        printLeastNumbers(array, 4);
    }
}
