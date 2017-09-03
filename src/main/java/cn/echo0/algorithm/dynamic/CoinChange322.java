package cn.echo0.algorithm.dynamic;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/02/2017 07:22 PM
 */
public class CoinChange322 {
    //    You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    private static int maxValue = Integer.MAX_VALUE >> 1;


    public static int coinChangeCore(int index, int amount, int[] coins,int[][]res) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || index >= coins.length) {
            return maxValue;
        }
        if (res[index][amount-1]!=Integer.MIN_VALUE){
            return res[index][amount-1];
        }
        //选择当前硬币
        int selectedRes = coinChangeCore(index, amount - coins[index], coins,res) + 1;
        //不选
        int unselectedRes = coinChangeCore(index + 1, amount, coins,res);
        res[index][amount-1]=Math.min(selectedRes, unselectedRes);
        return res[index][amount-1];
    }

    public static int coinChange(int[] coins, int amount) {
        int [][]results = new int[coins.length][amount];
        for (int i = 0; i < coins.length; i++)
            for (int j = 0; j < amount; j++)
                results[i][j] = Integer.MIN_VALUE;

        int res = coinChangeCore(0, amount, coins,results);
        if (res >= maxValue) {
            return -1;
        } else return res;
    }

    public static void main(String[] args) {


        int[]coins = new int[]{2};
        int amount = 1;
        System.out.println(coinChange(coins,amount));
    }

}
