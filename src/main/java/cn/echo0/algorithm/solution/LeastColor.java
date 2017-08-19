package cn.echo0.algorithm.solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/19/2017 02:19 PM
 */
public class LeastColor {
    //    你就是一个画家！你现在想绘制一幅画，
//    但是你现在没有足够颜色的颜料。为了让问题简单，
//    我们用正整数表示不同颜色的颜料。你知道这幅画需要的n种颜色的颜料，
//    你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合一些颜料。
//    混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。
//    本着勤俭节约的精神，你想购买更少的颜料就满足要求，
//    所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？
    public static int leastColorNum(int[] array) {
        Arrays.sort(array);
        int numOfZero = 0;
        for (int i = array.length - 1; i > 0; i--) {//求梯形矩阵
            for (int j = i - 1; j >= 0; j--) {
                if ((array[j] ^ array[i]) < array[j]) {
                    array[j] ^= array[i];
                }
            }
        }
        for (int i = array.length-1;i>=0;i--){
            if (array[i]==0){
                numOfZero++;
            }
        }
//        System.out.println(Arrays.toString(array));
        return array.length -numOfZero;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(leastColorNum(array));
    }
}
