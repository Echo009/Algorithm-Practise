package cn.echo0.algorithm.search;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/30/2017 08:12 PM
 */
public class SearchinRotatedSortedArray33 {
    public static int search(int[] array,int target){
        if(array==null||array.length==0){
            return -1;
        }
        if(array.length == 1 ){
            return array[0] == target ? 0 : -1 ;
        }
        int left = 0 ;
        int right = array.length-1;
        int middle = 0;
        while(left <= right){
            middle = left + ( (right-left) >> 1 );
            if(array[middle]==target)
                return middle;
            if(array[middle]<array[left]){//位于后面的递增数组
                if(array[middle]<target)//小于，则有两种情况
                {
                    // right 小于target , 即后面的递增数组都小于target,此时应往前找
                    if(array[right]==target){
                        return right;
                    }
                    if(array[right]<target){
                        right = middle - 1 ;
                    }else{
                        left = middle + 1 ;
                    }
                }else{//大于
                    right = middle - 1 ;
                }
            }else{//位于前面的递增数组
                if(array[middle]<target){ // 小于的话只有一种情况
                    left = middle + 1 ;
                }else {
                    if(array[left]==target){
                        return left ;
                    }
                    // 大于 ， 则目标应位于前面，或者后面的递增数组
                    if(array[left]<target){
                        right = middle -1 ;
                    }else{
                        left = middle +1 ;
                    }
                }
            }
        }
        return -1 ;
    }
}
