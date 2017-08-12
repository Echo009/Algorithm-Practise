package cn.echo0.algorithm.bit;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/12/2017 09:29 PM
 */
public class AddOperation {

    public static int add(int a, int b ){
        int sum , carry ;
        do{
            sum=a^b;
            carry=(a&b)<<1;
            a=sum;
            b=carry;
        }while (carry>0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(719,920));
    }

}
