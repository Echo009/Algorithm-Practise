package cn.echo0.algorithm.trackback;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/29/2017 02:25 PM
 */
public class EightEueen {
    //八皇后问题
    static int solutions = 0;

    static void printSolutions() {
        int[] columnIndex = new int[8];
        printSolutions(columnIndex, 0);
    }

    private static void printSolutions(int[] columnIndex, int currentQueenIndex) {
        if (currentQueenIndex > 7) {
            System.out.println(Arrays.toString(columnIndex));
            solutions++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            columnIndex[currentQueenIndex] = i;
            if (check(columnIndex, currentQueenIndex)) {
                printSolutions(columnIndex, currentQueenIndex + 1);
            }
        }
    }

    private static boolean check(int[] columnIndex, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (columnIndex[i] - columnIndex[currentIndex] == i - currentIndex
                    || columnIndex[i] - columnIndex[currentIndex] == currentIndex - i ||//位于对角线上
                    columnIndex[i] == columnIndex[currentIndex]) { //同一列
                return false;
            }
        }
        return true;
    }

    //先求出不同列的全排列，再判断
    static void printSolutionsArranges() {
        int[] columnIndex = new int[8];
        for (int i = 0; i < 8; i++) { // init
            columnIndex[i] = i;
        }
        arrangeArray(columnIndex, 0);
    }

    private static void arrangeArray(int[] array, int currentIndex) {
        if (currentIndex >= array.length) {
            if (check(array)) {
                System.out.println(Arrays.toString(array));
            }
            return;
        }
        for (int i = currentIndex; i < array.length; i++) {
            if(i!=currentIndex){
                array[currentIndex] ^= array[i];
                array[i] ^= array[currentIndex];
                array[currentIndex] ^= array[i];
            }
            arrangeArray(array, currentIndex + 1);

            if(i!=currentIndex){
                array[currentIndex] ^= array[i];
                array[i] ^= array[currentIndex];
                array[currentIndex] ^= array[i];
            }
        }
    }

    private static boolean check(int[] columnIndex) {
        for (int i = 0; i < columnIndex.length - 1; i++) {
            for (int j = i + 1; j < columnIndex.length; j++) {
                if (columnIndex[i] - columnIndex[j] == i - j
                        || columnIndex[i] - columnIndex[j] == j - i ||//位于对角线上
                        columnIndex[i] == columnIndex[j]) { //同一列
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        printSolutions();
        Instant end = Instant.now();
        System.out.println("Use time :" + Duration.between(start, end).toMillis());
        System.out.println(solutions);
        start = Instant.now();
        printSolutionsArranges();
        end = Instant.now();
        System.out.println("Use time :" + Duration.between(start, end).toMillis());
    }
}
