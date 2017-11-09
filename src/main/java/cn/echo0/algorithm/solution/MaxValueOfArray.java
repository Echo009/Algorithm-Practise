/*
*start code
*/
package cn.echo0.algorithm.solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author : Echo0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 2017/10/12 19:55
 */
public class MaxValueOfArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int []array;
//        System.out.println(scanner.next());
//        System.out.println(n);
//        for (int i = 0; i<n;i++){
//            array[i]=scanner.nextInt();
//        }
        String input = scanner.next();
        String[] temp = input.split(",");

//        System.out.println(Arrays.toString(temp));
        array=Arrays.stream(temp).mapToInt(s -> Integer.valueOf(s)).toArray();
        int maxValue = 0 ;
        int minValue = Integer.MAX_VALUE;
        int currentMaxSum = 0 ;
        int currentMinSum = 0;
        int sum =0;
        for (int i = 0 ; i < n ; i ++ ){
            currentMaxSum+=array[i];
            currentMinSum+=array[i];
            sum+=array[i];
            // max value
            if(maxValue<currentMaxSum){
                maxValue=currentMaxSum;
            }
            if (currentMaxSum < 0) {
                currentMaxSum = 0 ;
            }
            // min value

            if (minValue>currentMinSum){
                minValue=currentMinSum;
            }
            if (minValue<currentMinSum){
                currentMinSum=0;
            }

        }
//        System.out.println(maxValue);
//        System.out.println(minValue);
        maxValue = maxValue > sum-Math.abs(minValue) ? maxValue:sum-Math.abs(minValue);
        System.out.println(maxValue);
    }
}
