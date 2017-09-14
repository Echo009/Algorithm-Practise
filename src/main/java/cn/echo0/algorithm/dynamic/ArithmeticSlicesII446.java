package cn.echo0.algorithm.dynamic;


/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/13/2017 03:22 PM
 */
public class ArithmeticSlicesII446 {
//    A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.
//
//    The function should return the number of arithmetic subsequence slices in the array A.
//
//    The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.


    private static int dp(int[] array, int preIdx, int currentIdx, long diff, int length) {// length ： length of current sub sequence
        int result = 0;

        if (currentIdx>=array.length){
            return result; // 0
        }

        if (preIdx == -1) {//first number of sequence
            // select current number
            result += dp(array,currentIdx,currentIdx+1,diff,length+1);
            // unselect
            result += dp(array,-1,currentIdx+1,diff,length);
        }
        else {
            // second number
            if(length<2){
                // select current number
                result += dp(array,currentIdx,currentIdx+1,
                        (long)array[currentIdx]-array[preIdx],length+1);

                // unselect
                result += dp(array,preIdx,currentIdx+1,diff,length);
            }
            else {
                // can select current number
                if ((long)array[currentIdx]-array[preIdx]==diff){
                    // select
                    result += dp(array,currentIdx,currentIdx+1,diff,length+1)+1;
                    // unselect
                    result += dp(array,preIdx,currentIdx+1,diff,length);
                }
                else
                    result += dp(array,preIdx,currentIdx+1,diff,length);
            }
        }
        return result;
    }

    public static int numberOfArithmeticSlices(int[] A) {

        return dp(A,-1,0,Integer.MAX_VALUE,0);
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1
                ,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }

}
