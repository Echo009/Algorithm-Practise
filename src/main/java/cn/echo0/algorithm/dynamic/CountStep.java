package cn.echo0.algorithm.dynamic;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/24/2017 03:09 PM
 */
public class CountStep {
    //给定一个数，从一开始，每步只能减一或者*2，问最少多少步可以得到答案 ？

    public static int steps(int begin , int target ){
        if (begin==target){
            return 0;
        }
        else {
            int result1 = Integer.MAX_VALUE;
            if (begin*2<=target){
                result1 = steps(begin*2,target)+1 ;
            }
            return Math.min(steps(begin+1,target)+1,result1);
        }
    }
    public static void main(String[] args) {
        System.out.println(steps(1,8));
    }
}
