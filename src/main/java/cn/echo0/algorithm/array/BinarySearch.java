package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/03/2017 04:13 PM
 */
public class BinarySearch {
    public static int getPos(int[] A, int n, int val) {
        // write code here
        int middle  ;
        int start = 0;
        int end = n-1 ;
        while(start <= end){
            middle = (start+end)>>1;
            if(A[middle]==val){
                if(middle==0||A[middle-1]!=val)
                    return middle;
                else {
                    while(middle>0&&A[middle-1]==val){
                        middle--;
                    }
                    return middle;
                }
            }
            if(A[middle]>val)
                end = middle-1;
            else start = middle+1 ;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getPos(new int[]{1,2,3,5},4,1));
    }
}
