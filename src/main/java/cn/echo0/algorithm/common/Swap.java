package cn.echo0.algorithm.common;

import java.util.Arrays;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/8 10:56
 */
public class Swap {
    public static void swapIntArray(int[] array , int i , int j ){
        array[i]=array[j]^array[i];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }
    public static void main(String[] args) {
        int []array = {1,8};
        swapIntArray(array,0,1);
        System.out.println(Arrays.toString(array));
    }
}
