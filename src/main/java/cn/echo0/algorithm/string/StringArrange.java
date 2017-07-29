package cn.echo0.algorithm.string;

import java.util.Arrays;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/29/2017 01:52 PM
 */
public class StringArrange {
    //    输出一个字符串的全排列
    static void permutation(char[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        permutation(str, 0);
    }

    static void permutation(char[] str, int currentIndex) {
        int length = str.length;
        if (currentIndex >= length) {
            System.out.println(Arrays.toString(str));
        }
        for (int target = currentIndex; target < length; target++) {

            char temp = str[target];
            str[target] = str[currentIndex];
            str[currentIndex] = temp;

            permutation(str, currentIndex + 1);

            temp = str[target];
            str[target] = str[currentIndex];
            str[currentIndex] = temp;


        }
    }

    public static void main(String[] args) {
        permutation("lovelanlan".toCharArray());
    }
}
