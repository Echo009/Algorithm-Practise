package cn.echo0.algorithm.dynamic;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/19/2017 02:15 PM
 */
public class CutRope {
    //    剪绳子
    public static int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }

        int[] maxProduct = new int[length+1];
        maxProduct[0] = 0;
        maxProduct[1] = 1;
        maxProduct[2] = 2;
        maxProduct[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++ ){// 从下至上求解
            max = 0;
            for (int j = 1; j<= i/2 ; j ++ ) {
                int temp = maxProduct[j] * maxProduct[i-j];
                if(max<temp ){
                    max=temp;
                }
            }
            maxProduct[i] = max ;
        }
        return maxProduct[length];
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(5));
    }
}
