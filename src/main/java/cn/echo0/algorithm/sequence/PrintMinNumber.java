package cn.echo0.algorithm.sequence;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/01/2017 01:24 PM
 */
public class PrintMinNumber {
    //给定一个正整数数组，将数组里的所有数字拼接起来排成一个数，打印出能拼接出的所有数字中的最小的一个
    static void printMinNumber(int []array){
        if (array==null||array.length==0){
            return;
        }
       String [] temp = new String[array.length];
       for (int i=0;i<array.length;i++){
           temp[i]=array[i]+"";
       }
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int sum1 = Integer.valueOf(o1+o2);
                int sum2 = Integer.valueOf(o2+o1);
                if(sum1==sum2)
                    return 0;
                if (sum1<sum2){
                    return -1;
                }
                return 1;
            }
        });
        for (int i = 0;i<temp.length;i++){
            System.out.print(temp[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[]array = new int[]{3,32,321};
        printMinNumber(array);
    }
}
