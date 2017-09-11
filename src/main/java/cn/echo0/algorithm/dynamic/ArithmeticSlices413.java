package cn.echo0.algorithm.dynamic;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/11/2017 11:18 AM
 */
public class ArithmeticSlices413 {
//    A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
//
//            A slice (P, Q) of array A is called arithmetic if the sequence:
//    A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
//
//    The function should return the number of arithmetic slices in the array A.


    public static int dp(int [] array , int currentIdx , int diff , int currentLen){

        int result = 0 ;
        if (currentIdx==array.length){
            return 0;
        }
        // judge
        if (array[currentIdx]-array[currentIdx-1]==diff){
            if (currentLen>=3){
                result++;
            }

            result += dp(array,currentIdx+1,diff,currentLen+1);

        }
        return result;
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        for (int i=0; i <= A.length - 3 ; i++){
           result+= dp(A,i+1,A[i+1]-A[i],2);//start with i
        }
        return result;
    }
    public static int numberOfArithmeticSlices_circulation(int[] A) {
        int result = 0;
        for (int i=0; i <= A.length - 3 ; i++){//start with i
            int diff = A[i+1]-A[i];
            for (int j = i+2 ; j < A.length;j++){
                if (A[j]-A[j-1] != diff){
                    break;
                }
                if (j-i+1 >= 3 ){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4};
        System.out.println(numberOfArithmeticSlices_circulation(array));
    }
}
