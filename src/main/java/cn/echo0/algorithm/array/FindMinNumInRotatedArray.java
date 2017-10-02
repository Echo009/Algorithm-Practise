package cn.echo0.algorithm.array;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/8 11:34
 */
public class FindMinNumInRotatedArray {
    //  将一个排好序的数组 的前面的若干个数整体移动到数组的末尾，这样的数组成为旋转数组，现给出一个旋转数组
    //  请找出数组中最小的元素
    public static int findMinNumber(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int left = 0 ;
        int right = array.length-1;
        int middle = left ;
        while(array[left] >= array[right]){
            if(left+1==right){
                break;
            }
            middle = left + ((right-left)>>1);
            if(array[left]==array[middle]&&array[middle]==array[right]){
                return finMInInOrder(array);
            }
            if(array[middle]<array[left]){
                right=middle;
            }else
                left=middle;
        }
        return array[right];
    }

    public static int finMInInOrder(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            min = (min < array[i]) ? min : array[i];
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        int[] array = {1, 2 , 6 , 0, 1};
        System.out.println(findMinNumber(array));
    }
}
