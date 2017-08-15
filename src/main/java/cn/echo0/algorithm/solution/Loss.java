package cn.echo0.algorithm.solution;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/15/2017 11:16 PM
 */
public class Loss {
    private static long maxLoss(long endurance) {
//        x*x+x-endurance<=0;
        long delta = 1 + endurance * 4;

        double temp = (Math.sqrt(delta) - 1) / 2;
        return (long) temp;
    }

    private static int maxLoss_(int endurance) {
        long x = (long) Math.pow(endurance, 0.5);
        if (x * (x + 1) > endurance) {
            return (int) x - 1;
        } else {
            return (int) x;
        }
    }


    public static void main(String[] args) {
        System.out.println(maxLoss(1234567890));
    }
}
