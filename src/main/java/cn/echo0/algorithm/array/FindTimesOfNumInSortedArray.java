package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/05/2017 05:15 PM
 */
public class FindTimesOfNumInSortedArray {
    //    输出num在数组中出现的次数
    public static int findTimesOfNum(int[] array, int num) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        return getLastIndexOfNum(array, num, 0, array.length) - getFirstIndexOfNum(array, num, 0, array.length) + 1;

    }

    private static int getFirstIndexOfNum(int[] array, int num, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) >> 1;
        if (array[middle] == num && (middle == 0 || array[middle - 1] != num)) {
            return middle;
        } else if (array[middle] < num) {
            start = middle + 1;
        } else
            end = middle - 1;
        return getFirstIndexOfNum(array, num, start, end);
    }

    private static int getLastIndexOfNum(int[] array, int num, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) >> 1;
        if (array[middle] == num && (middle == array.length - 1 || array[middle + 1] != num)) {
            return middle;
        } else if (array[middle] <= num) {
            start = middle + 1;
        } else
            end = middle - 1;
        return getLastIndexOfNum(array, num, start, end);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 3, 8, 9};
        System.out.println(findTimesOfNum(array, 3));
    }
}
