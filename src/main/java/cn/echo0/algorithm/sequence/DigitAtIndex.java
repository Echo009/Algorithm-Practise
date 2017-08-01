package cn.echo0.algorithm.sequence;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/01/2017 12:53 PM
 */
public class DigitAtIndex {
    //    数字以012345678910111213...的格式序列化一个字符序列。请求出在这个序列中第n位对应的数字
    static int digitAtIndex(int index) {
        if (index<0){
            throw new IllegalArgumentException();
        }
        int digit = 1;
        while (true) {
            if (index < countOfIntegers(digit)*digit) {
                return numberOfIndex(index,digit);
            }
            index-=countOfIntegers(digit)*digit;
            digit++;
        }

    }

    static int countOfIntegers(int digit) {//返回对应位数的数字有多少个
        if (digit == 1)
            return 10;
        int start = (int) Math.pow(10, digit - 1);
        int end = (int) Math.pow(10, digit) - 1;
        return end - start + 1;
    }

    static int numberOfIndex(int index, int digit) {
        if(digit==1){
            return index;
        }
        int number = (int) Math.pow(10, digit - 1) + index / digit ;
        index = index % digit;
        int indexFromRight = digit  - index ;
        for (int i = 1;i<indexFromRight ; ++i){
            number = number/10;
        }
        return number%10;

    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(1001));
    }
}
