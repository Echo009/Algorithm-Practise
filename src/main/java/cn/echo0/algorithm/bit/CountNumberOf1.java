package cn.echo0.algorithm.bit;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/20/2017 09:20 AM
 */
public class CountNumberOf1 {
    //给定一个整数，返回其对应二进制数中1的个数。
    public static int countOf1(int number) {
        int count = 0;
        while (number != 0) {
            number = (number - 1) & number;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOf1(0x7fff_ffff));
    }
}
