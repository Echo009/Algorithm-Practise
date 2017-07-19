package cn.echo0.algorithm.dynamic;

import java.time.Duration;
import java.time.Instant;

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

        int[] maxProduct = new int[length + 1];
        maxProduct[0] = 0;
        maxProduct[1] = 1;
        maxProduct[2] = 2;
        maxProduct[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++) {// 从下至上求解
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = maxProduct[j] * maxProduct[i - j];
                if (max < temp) {
                    max = temp;
                }
            }
            maxProduct[i] = max;
        }
        return maxProduct[length];
    }

    public static int maxProductAfterCuttingGreedy(int length) {
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }
        int timeOf3 = length / 3;
        //当剩余长度为4的时候应该剪为2*2
        if (length % 3 == 1) {
            timeOf3--;
        }
        int timeOf2 = (length - timeOf3 * 3) / 2;
        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println(maxProductAfterCutting(5000));
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toNanos());
        start = Instant.now();
        System.out.println(maxProductAfterCuttingGreedy(5000));
        end = Instant.now();
        duration = Duration.between(start, end);
        System.out.println(duration.toNanos());
    }
}
