package cn.echo0.algorithm.solution;

import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/15/2017 09:14 PM
 */
public class Template {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int []array=new int[n];
        for (int i = 0; i<n;i++){
            array[i]=scanner.nextInt();
        }
    }
}
