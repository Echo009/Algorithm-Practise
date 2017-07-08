package cn.echo0.algorithm.sort;

import cn.echo0.algorithm.common.Swap;

import java.util.Arrays;

import static cn.echo0.algorithm.common.GenArray.genIntArray;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/8 10:43
 */
public class QuickSort {

    public static void sort(int[] array, int start, int end) {
        if (array == null || start >= end || array.length == 0) {
            return;
        }
        if (start < end) {
            int pivot = array[start]; // use the first element as pivot
            int i = start, j = end;
            while (i < j) {
                while (array[j] > pivot && j > i) {
                    j--;
                }
                if (j > i) {
                    Swap.swapIntArray(array, j, i);
                }
                while (array[i] < pivot && j > i) {
                    i++;
                }
                if (j > i) {
                    Swap.swapIntArray(array, i, j);
                }
            }
            array[i] = pivot;
            sort(array, start, i - 1);
            sort(array, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = genIntArray(20);
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
