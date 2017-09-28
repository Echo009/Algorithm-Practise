package cn.echo0.algorithm.dynamic;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/28/2017 10:45 PM
 */
public class JumpII {
//    一只青蛙一次可以跳上1级台阶，也可以跳上2级……
// 它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public int JumpFloorII(int target) {
        if (target < 3) {
            return target;
        }
        int[] strategys = new int[target + 1];
        strategys[1] = 1;
        strategys[2] = 2;
        for (int i = 3; i <= target; i++) {
            for (int j = i - 1; j > 0; j--) {
                strategys[i] += strategys[j];
            }
            strategys[i]++;
        }
        return strategys[target];
    }
}
