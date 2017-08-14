package cn.echo0.algorithm.print;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/14/2017 03:28 PM
 */
public class PrintNumTriangle {
    public static void printNumTriangle(int num) {
        int rowSum = (num << 1 )- 1;
        for (int i = 1; i <= num; i++) {
            int start = (rowSum - 2 * i + 1) >> 1;
            boolean flag = false;
            for (int j = 1; j <= rowSum; j++) {

                if (j > start && j <= rowSum - start){
                    if (flag){
                        System.out.print(" ");

                    }else {
                        System.out.print(i);
                    }
                    flag=!flag;

                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i =num-1;i>=1;i--){
            int start = (rowSum - 2 * i + 1) >> 1;
            boolean flag = false;
            for (int j = 1; j <= rowSum; j++) {

                if (j > start && j <= rowSum - start){
                    if (flag){
                        System.out.print(" ");

                    }else {
                        System.out.print(i);
                    }
                    flag=!flag;

                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printNumTriangle(4);
    }
}
