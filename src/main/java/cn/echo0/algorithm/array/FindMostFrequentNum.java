package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/30/2017 07:16 PM
 */
public class FindMostFrequentNum {
//    在数组中找到出现次数超过一半的数字
    static int findMoreThanHalfNum(int [] array){
        if(array==null||array.length==0){
            throw new IllegalArgumentException();
        }
        int theTargetNum = array[0];
        int times =1;
        for (int i = 1;i<array.length;i++){
            if (times==0){
                theTargetNum = array[i];
                times++;
            }
            else {
                if (theTargetNum!=array[i]){
                    times--;
                }else {
                    times++;
                }
            }
        }
        return theTargetNum;
    }
    private static int [] intArray = new int[]{2,2,1, 3,3,3 ,4,93,3,3,3 ,3};
    public static void main(String[] args) {
        System.out.println(findMoreThanHalfNum(intArray));
    }
}
