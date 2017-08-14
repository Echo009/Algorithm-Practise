package cn.echo0.algorithm.array;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/09/2017 10:16 AM
 */
public class FindContinuousSeq {
    private static void printSeq(int min, int max) {
        for (int i = min; i <= max; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void findContinousSeq(int sum) {
        if (sum <= 1) {
            System.out.println(" IllegelArguments !");
            return;
        }
        int min = 1;
        int max = 2;
        int currentSum = min + max;
        while (min < max) {
            if (currentSum == sum) {
                printSeq(min, max);
                max++;
                currentSum += max;
            } else if (currentSum < sum) {
                max++;
                currentSum += max;
            } else {
                min++;
                currentSum -= min - 1;
            }
        }
        return;
    }

    public static void main(String[] args) {
        findContinousSeq(901);
    }
}
