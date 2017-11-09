/*
*start code
*/
package cn.echo0.algorithm.solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author : Echo0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 2017/10/11 15:54
 */
public class Triangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[4];

        while (scanner.hasNext()) {
            for (int i = 0; i < 4; i++) {
                array[i] = scanner.nextInt();
            }
            //sort
            Arrays.sort(array);
            if (array[0]+array[1]>array[2]||
                    array[0]+array[1]>array[3]||
                    array[1]+array[2]>array[3]){
                System.out.println("triangle");
            }else if (array[0]+array[1]==array[2]||
                    array[0]+array[1]==array[3]||
                    array[1]+array[2]==array[3]||
                    array[0]+array[2]==array[3]){
                System.out.println("segment");
            }else System.out.println("impossible");
        }
    }

}
