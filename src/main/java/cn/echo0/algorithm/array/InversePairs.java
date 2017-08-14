package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/05/2017 04:14 PM
 */
public class InversePairs {
    //    给定一个数组，求其中逆序数的 对数
    public static int countInversePairs(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] temp = new int[array.length];
        return countCore(temp, array, 0, array.length - 1);
    }

    private static int countCore(int[] copy, int[] array, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = countCore(array, copy, start, start + length);
        int right = countCore(array, copy, start + length + 1, end);
        int i = start + length;
        int j = end;
        int indexOfCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                count += j - length - start;
                copy[indexOfCopy--] = array[i--];
            } else copy[indexOfCopy--] = array[j--];
        }
        for (; i >= start; --i) {
            copy[indexOfCopy--] = array[i];
        }
        for (; j >= start + length + 1; --j) {
            copy[indexOfCopy--] = array[j];
        }
        return left + right + count;

    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 6, 4};
        System.out.println(countInversePairs(array));
    }
}
