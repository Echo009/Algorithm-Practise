package cn.echo0.algorithm.array;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/8 11:34
 */
public class FindMinNumInRotatedArray {
    //  将一个排好序的数组 的前面的若干个数整体移动到数组的末尾，这样的数组成为旋转数组，现给出一个旋转数组
    //  请找出数组中最小的元素
    public static int findMinNumber(int[] array) throws Exception {
        if (array == null || array.length == 0)
            throw new Exception("Incorrect argument ! ");
        if (array.length == 1) {
            return array[0];
        }
        int index1 = 0;
        int index2 = array.length - 1;
        int middleIndex = index1;
        while (index1 < index2) {
            if (array[index1] < array[index2]) {//数组没有被旋转
                return array[middleIndex];
            }
            if (index1 == index2 - 1) {
                break;
            }
            middleIndex = (index1 + index2) / 2;
            if (array[middleIndex] > array[index1]) // 在后半部分
            {
                index1 = middleIndex;
            } else if (array[middleIndex] < array[index2]) {// 在前半部分
                index2 = middleIndex;
            } else if (array[middleIndex] == array[index1] && array[index1] == array[index2]) {
                return finMInInOrder(array);
            }
        }
        return array[index2];
    }

    public static int finMInInOrder(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            min = (min < array[i]) ? min : array[i];
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        int[] array = {1, 1, 1, 0, 1};
        System.out.println(findMinNumber(array));
    }
}
