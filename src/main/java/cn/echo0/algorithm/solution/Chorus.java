package cn.echo0.algorithm.solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/17/2017 03:15 PM
 */
public class Chorus {
    //    有 n 个学生站成一排，每个学生有一个能力值，
//    牛牛想从这 n 个学生中按照顺序选取 k 名学生，
//    要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，
//    你能返回最大的乘积吗？
//    1 <= k <= 10, 1 <= d <= 50,1 <= n <= 50
    private static long[][] max = new long[50][10];
    private static long[][] min = new long[50][10];

    private static long maxProduct(int[] array, int length, int num, int maxGap) {//incorrect
        long answer = 0;
        for (int i = 0; i < array.length; i++) {
            max[i][0] = array[i]; //init
        }
        for (int i = 0; i < length; i++) {//index of first number
            for (int j = 1 ; j < num && i + num - 1 <= length; j++) {// 第几个数
                for (int k = 0; k < i; k++) {// 遍历之前的最大值
                    for (int l = 1; l <= maxGap && l+j<length; l++) { // 当前可能的取值
                        max[i][j] = Math.max(Math.max(max[i][j], max[k][j - 1] * array[l + j]),min[k][j - 1] * array[i]);
//                        System.out.println("i:"+i+" j:"+j+"   "+ max[i][j]);
                        min[i][j] = Math.min(Math.min(min[i][j], min[k][j - 1] * array[l + j]),max[k][j - 1] * array[i]);
                    }

                }
            }
        }
        for (int i = 0; i<length&& i + num - 1 <= length;i++){
            answer=Math.max(max[i][num-1],answer);

        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int []array = new int[length];
        for (int i = 0;i<length;i++){
            array[i]= sc.nextInt();
        }
        int num =sc.nextInt();
        int maxGap = sc.nextInt();
        System.out.println(maxProduct(array,length,num,maxGap));

    }
}
