package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/06/2017 10:58 PM
 */
public class FindNumberSameAsIndex {
    public static int findNumberSameAsIndex(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        int start = 0;
        int end = array.length;
        int middle;
        while (start <= end) {
            middle = (end + start) >> 1;
            if (middle == array[middle]) {
                return middle;
            } else if (middle > array[middle]) {
                start = middle + 1;
            } else end = middle - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-3, -1, 1, 3, 5};
        System.out.println(findNumberSameAsIndex(array));
    }
}
