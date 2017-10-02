package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/07/2017 10:06 AM
 */
public class FindNumsAppearOnce {
    //    找到数组中两个只出现一次的数字，其他的数字均出现偶数次
    public static void findNumsAppearOnce(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        int firstIndexOf1;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        firstIndexOf1 = findFirstBitOf1(result);
        if (firstIndexOf1 == -1) {
            System.out.println("   no matched nums !");
        }
        int num1 = 0, num2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], firstIndexOf1)) {
                num1 ^= array[i];
            } else
                num2 ^= array[i];

        }
        System.out.println(num1 + "  " + num2);
    }

    private static int findFirstBitOf1(int num) {
        int i = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                return i;
            }
            i++;
            num = num >> 1;
        }
        return -1;
    }

    private static boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] arrray = new int[]{1, 2, 3, 4, 5, 5, 6, 6, 4, 3};
        findNumsAppearOnce(arrray);

    }
}
