package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 10/19/2017 12:13 PM
 */
public class SearchFNumNearTarget {

    // 从浮点数数组中找到最接近给定数字的数的下标 <= target

   static double [] array  = new double[]{0.88,2.99,4.88,5.89,6.78
            ,6,88,7.99,8.99,8.999,9.78};

    public static int findIdxOfTargetNum(double[]array ,  double target){

        int len = array.length;
        if (len==0)return -1;

        int begin , end ;
        begin = 0 ; end = len -1 ;
        int mid ;
        while (begin<end){
            mid = begin + (end-begin) / 2 ;
            if (array[mid]==target){
                return mid;
            }
            if (array[mid]<target&& mid+1 < len &&array[mid+1]>target){
                return mid;
            }
            if (array[mid]>target&& mid-1 > 0 &&array[mid-1]<target){
                return mid-1;
            }
            if (array[mid]<target){
                begin = mid;
            }else if (array[mid]>target){
                end = mid ;
            }
        }

        return  -1 ;
    }

    public static void main(String[] args) {

        System.out.println(findIdxOfTargetNum(array,10));

    }


}
