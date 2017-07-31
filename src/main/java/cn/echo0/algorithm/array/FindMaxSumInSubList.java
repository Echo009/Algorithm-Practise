package cn.echo0.algorithm.array;

import java.util.Arrays;


/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/31/2017 08:32 PM
 */
public class FindMaxSumInSubList {
    static int findMaxSumInSubList(int [] array)throws IllegalArgumentException{
        int maxSum = Integer.MIN_VALUE;
        if (array==null||array.length==0){
            throw new IllegalArgumentException();
        }
        int currentSum=Integer.MIN_VALUE;
        for (int i = 0;i<array.length;i++){
            if(currentSum<0){
                currentSum=array[i];
            }
            else {
                currentSum+=array[i];
            }
            if (currentSum>maxSum){
                maxSum=currentSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int []array = new int[]{-1,-2,-3,-10,-4,8,-2,9};
        System.out.println(Arrays.toString(array));
        System.out.println(findMaxSumInSubList(array));
    }
}
