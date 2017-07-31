package cn.echo0.algorithm.common;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/8 11:13
 */
public class GenArray {
    public static int [] genIntArray (int length ){
       return IntStream.generate(()->new Random().nextInt(1888)-1000).limit(length).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(genIntArray(10)));
    }
}
