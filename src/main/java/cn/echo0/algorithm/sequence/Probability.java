package cn.echo0.algorithm.sequence;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/11/2017 03:16 PM
 */
public class Probability {
    //    把n个骰子扔在地上，所有骰子朝上一面的点数之和为s，输入n，打印出s的所有可能值出现的概率
    private static final int MAX_VALUE = 6;//定义最大点数

    public static void printProbability(int number) {
        int maxSum = MAX_VALUE * number;
        int[][] timesRecord = new int[2][maxSum + 1];//记录对应点数出现的次数
        int flag = 1;
        //init
        for (int i = 1; i <= MAX_VALUE; i++) {  //一个骰子的情况下
            timesRecord[flag][i] = 1;
        }
        //从第二个骰子开始计算
        for (int i = 2; i <= number; i++) {
            for (int j = 0; j < number; j++)//number*1 之前的元素出现次数应该都为0
            {
                timesRecord[1 - flag][j] = 0;
            }
            for (int j = number; j <= number * MAX_VALUE; j++) {

                for (int k = 1; k <= j && k <= MAX_VALUE; k++) {
                    timesRecord[1 - flag][j] += timesRecord[flag][j - k];
                }
            }
//            reverse flag
            flag = 1 - flag;
        }
        double maxTimes = Math.pow(MAX_VALUE, number);
        for (int i = number; i <= MAX_VALUE * number; i++) {
            System.out.println(i + " : " + timesRecord[flag][i] / maxTimes);
        }
    }

    public static void main(String[] args) {
        printProbability(2);
    }
}
