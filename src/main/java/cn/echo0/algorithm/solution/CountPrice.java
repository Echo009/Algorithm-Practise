/*
*start code
*/
package cn.echo0.algorithm.solution;

import java.util.Scanner;

/**
 * Author : Echo0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 2017/10/11 16:05
 */
public class CountPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();
        if (weight<=10){
            System.out.println("3.50");
        }else {
            System.out.printf("%2.2f",3.5+(weight-10)*0.75);
        }

    }
}
