package cn.echo0.algorithm.Input;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/01/2017 07:14 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int [] count = countNum(str);
        System.out.println(Arrays.toString(count));
        System.out.println(getMinNumOfPlalindrome(count));
    }
    private static int getMinNumOfPlalindrome(int[]array){
        int oddNum=0;
        for (int i = 0;i<array.length;i++){
            if (array[i]==0){
                continue;
            }
            if ( (array[i]&1)==1  ){//odd
                oddNum ++ ;
            }
        }
        return oddNum;
    }
    private static int[] countNum (String str){
        int [] count = new int[26];
        for (int i = 0;i<str.length();i++)
        {
            count[str.charAt(i)-97]++;
        }
        return count;
    }

    private static boolean check(String str,int index){
        int firSeqLastIndex = index/2;
        while (firSeqLastIndex>=0){
            if(str.charAt(firSeqLastIndex)!=str.charAt(index)){
                return false;
            }
            firSeqLastIndex--;
            index--;
        }
        return true;
    }
}