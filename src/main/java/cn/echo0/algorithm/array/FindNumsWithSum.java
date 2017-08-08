package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/08/2017 10:46 AM
 */
public class FindNumsWithSum {
//    在排序数组中找到和为给定值的一对数
    public static void findNumsWithSum(int [] array,int sum){
        if (array==null||array.length==0)
        {
            throw new IllegalArgumentException();
        }
        int head = 0;
        int rear = array.length-1;
        int temp ;
        while (head<rear){
            temp=array[head]+array[rear];
            if (temp==sum){
                System.out.println(array[head]+"+"+array[rear]+"="+sum);
                return;
            }
            else if (temp<sum){
                head++;
            }
            else rear--;
        }
        System.out.println( "  no matched results !");
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,4,5,5,6,6,7,8,9,11,22};
       findNumsWithSum(array,8);
    }
}
