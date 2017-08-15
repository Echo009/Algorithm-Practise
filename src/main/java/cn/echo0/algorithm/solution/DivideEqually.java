package cn.echo0.algorithm.solution;

import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/15/2017 09:03 PM
 */
public class DivideEqually {
    private static int countTimesDivideEqually(int n,int []array){

        int sum = 0;
        for (int i = 0;i<n ;i++){
            sum+=array[i];
        }
        if (sum%n!=0){ // 不能被整除必定不能平分
            return -1;
        }
        int average = sum/n;
        int times=0;
        for (int i = 0;i < n ; i++){
            if (array[i]>average){
                int temp = array[i]-average;
                if(temp%2!=0){
                    return -1;
                }
                else times+=temp/2;
            }
            else if (array[i]<average){
                int temp =average-array[i];
                if(temp%2!=0){
                    return -1;
                }
            }
        }
        return times;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int []array=new int[n];
        for (int i = 0; i<n;i++){
            array[i]=scanner.nextInt();
        }
        System.out.println(countTimesDivideEqually(n,array));
    }
}
