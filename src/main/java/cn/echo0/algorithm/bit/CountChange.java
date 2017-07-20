package cn.echo0.algorithm.bit;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/20/2017 09:42 AM
 */
public class CountChange {
    //给定两个整数，计算需要改变其中一个数的二进制表示的多少位才可以得到另一个数
    public static int countChange(int m, int n) {
        int temp = m ^ n;
        int count = 0;
        while (temp != 0) {
            count++;
            temp = temp & (temp - 1);
        }
        return count;
    }
                                                    
    public static void main(String[] args) {
        System.out.println(countChange(9, 18));
    }
}
