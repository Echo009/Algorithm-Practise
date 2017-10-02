package cn.echo0.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/29/2017 03:09 PM
 */
public class PrintMinNum {
//    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
// 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
// 则打印出这三个数字能排成的最小数字为321323。

    public static String printMinNumber(int[] numbers) {

        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, new MyComparetor());
        StringBuilder sb = new StringBuilder(1 << 10);
        for (int temp : nums) {
            sb.append(temp);
        }
        return sb.toString();
    }

    public static class MyComparetor implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            long result1 = Long.valueOf(String.valueOf(o1) + o2);
            long result2 = Long.valueOf(String.valueOf(o2) + o1);
            return (int) (result1 - result2);
        }
    }

    public static void main(String[] args) {
        String result = printMinNumber(new int[]{2, 1, 3, 4, 5});
        System.out.println(result);
    }
}
