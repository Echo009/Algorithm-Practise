package cn.echo0.algorithm.sort;


import cn.echo0.algorithm.common.Swap;

import java.util.Arrays;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/12/2017 03:07 PM
 */
public class HIndex274 {

//    Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
//
//    According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."


    private static void quickSortCore(int[] array, int start, int end) {
        if (start >= end) {
            return ;
        }
        int i = start, j = end;
        int pivot = array[i];
        while (i < j) {

            while (array[j] > pivot && j > i) {
                j--;
            }
            if (j > i) {
                Swap.swapIntArray(array, i, j);
                i++;
            }
            while (array[i] < pivot && i < j) {
                i++;
            }
            if (j > i) {
                Swap.swapIntArray(array, i, j);
                j--;
            }
        }
        array[i] = pivot;
        quickSortCore(array, start, i - 1);
        quickSortCore(array, i + 1, end);

    }

    public static void quickSort(int[] array) {

        if (array.length == 0) {
            return ;
        }
        quickSortCore(array, 0, array.length - 1);
        return;

    }


    public static int hIndex(int[] citations) {
        if (citations.length==0){
            return 0;
        }
        quickSort(citations);
        int count = 0 ;
        for ( int idx= citations.length -1 ;  idx>=0 && citations[idx] >count; idx-- ){
            count ++ ;
        }
        return count ;
    }

    public  static  int hIndex_On(int [] citations){
        int length = citations.length;
        int[] buckets= new int[length+1];
        //记录引用次数
        for (int citation: citations) {
            if (citation>length){
                buckets[length]++;
            }else
                buckets[citation]++;
        }
        int count = 0;
        for (int i= length ; i >= 0 ; i --  ){
            count += buckets[i];
            if (count >= i){
                return i;
            }
        }
        return 0 ;
    }

    public static void main(String[] args) {
        int [] array = new int[]{0};
        System.out.println(hIndex_On(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(hIndex(array));
    }

}
