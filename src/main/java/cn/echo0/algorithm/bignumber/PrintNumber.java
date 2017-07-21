package cn.echo0.algorithm.bignumber;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/21/2017 08:34 AM
 */
public class PrintNumber {
//    给定一个n，打印出从1到最大的n位十进制数
    public static void printNumber(int n){
        char []number = new char[n];
        int bitCount = 0 ;
        while(bitCount<n){
            printNumberRecursive(number,bitCount,0);
            bitCount++;
        }
    }
    private static void printNumberRecursive(char[] number, int bitCount , int index){
        if(bitCount<index){
            if (number[0]!='0')
            printChar(number,bitCount);
            return;
        }
        for (int i = 0; i< 10 ; i++){
            number[index]= (char) (i+48);
            printNumberRecursive(number,bitCount,index+1);
        }
    }
    private static void printChar(char[] chars, int n){
        for (int i =0 ; i<= n;i++)
        System.out.print(chars[i]);
        System.out.println();
    }

    public static void main(String[] args) {
        printNumber(55);

    }
}

