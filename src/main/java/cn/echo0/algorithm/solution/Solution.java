package cn.echo0.algorithm.solution;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/02/2017 08:24 PM
 */
public class Solution {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public static int calculateMax(int[] prices) {
        int max = 0;
        if (prices.length <= 3) {
            return findMaxProfit(prices, 0, prices.length - 1);
        }
        for (int i = 0; i < prices.length ; i++) {
            int currentProfit;
            if(i==0){
                currentProfit = findMaxProfit(prices, 0, prices.length-1);
            }else if(i>=prices.length-2){
                currentProfit = findMaxProfit(prices,0,i);
            }
            else {
                currentProfit = findMaxProfit(prices, 0, i) + findMaxProfit(prices, i + 1, prices.length - 1);
            }
            if (max < currentProfit) {
                max = currentProfit;
            }
        }
        return max;
    }

    private static int findMaxProfit(int[] prices, int start, int end) {//[start,end]区间内一次买卖最大的收益

        int max = 0;
        int temp = 0;
        for (int i = end; i > start; i--) {
            for (int j = i - 1; j >= start; j--) {
                temp = prices[i] - prices[j];
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{29,63,75,4};
        System.out.println(calculateMax(prices));
    }
}
