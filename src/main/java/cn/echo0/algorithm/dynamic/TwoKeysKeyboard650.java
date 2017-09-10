package cn.echo0.algorithm.dynamic;

import java.util.Arrays;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/03/2017 01:56 PM
 */
public class TwoKeysKeyboard650 {
//    Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

//    Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
//    Paste: You can paste the characters which are copied last time.
//    Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

    public static int targetNum;
    private static int results[][];
    public static int minStepsCore(int clipbNum, int currentNum) {
        if (currentNum == targetNum) {
            return 0;
        }
        if (currentNum > targetNum) {
            // illegal status
            return Integer.MIN_VALUE;
        }
        if (results[clipbNum][currentNum-1] != -1){//has counted
            return results[clipbNum][currentNum-1] ;
        }
        // past
        int pastSteps = Integer.MIN_VALUE;
        if (clipbNum != 0) {
            pastSteps = minStepsCore(clipbNum, currentNum + clipbNum) + 1;
        }
        int copyAndPastSteps = minStepsCore(currentNum, currentNum << 1) + 2;
        int result = Integer.MIN_VALUE;
        if (pastSteps >= 0) {
            result = pastSteps;
        }
        if (copyAndPastSteps >= 0) {
            if (result < 0) {
                result = copyAndPastSteps;
            } else
                result = result < copyAndPastSteps ? result : copyAndPastSteps;
        }
        results[clipbNum][currentNum-1] = result;
        return  result;

    }

    public static int minSteps(int n) {
        targetNum = n;
        results=new int[targetNum][targetNum];
        for (int i=0;i<targetNum;i++){
            Arrays.fill(results[i],-1);
        }
        return minStepsCore(0, 1);
    }

    public static void main(String[] args) {
        System.out.println(minSteps(666));
       
    }

}
