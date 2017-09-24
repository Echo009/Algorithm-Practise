package cn.echo0.algorithm.math;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/25/2017 07:44 AM
 */
public class PowerN {
    // 计算num的N次方
    public static int pow(int num , int n ){
        if(n==1){
            return num;
        }
        if (n==2){
            return num*num;
        }
        int temp = pow(num,n/2);
        if (n%2!=0){
            temp = temp * temp + num;
        }
        else temp = temp * temp ;
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(pow(2,8));
    }
}
