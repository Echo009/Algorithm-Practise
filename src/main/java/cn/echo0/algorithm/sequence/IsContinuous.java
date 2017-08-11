package cn.echo0.algorithm.sequence;

import java.util.Arrays;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/11/2017 03:42 PM
 */
public class IsContinuous {
    public static boolean isContinuous(int[] array) {

        Arrays.sort(array); //排序
        int numOfZero = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                break;
            }
            numOfZero++;
        }
        int numOfZeroNeeded = 0;
        for (int i = 0; i + 1 < array.length; i++) {
            if (array[i] == array[i + 1] && array[i] != 0) {
                return false;
            }
            if (array[i] + 1 != array[i + 1]) {
                numOfZeroNeeded += array[i + 1] - array[i] - 1;
            }
        }
        if (numOfZero < numOfZeroNeeded) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 0, 1, 2, 4, 5, 3, 7};
        System.out.println(isContinuous(array));
    }
}
