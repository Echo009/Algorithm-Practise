package cn.echo0.algorithm.solution;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 10/18/2017 03:03 PM
 */
public class LuckMoney {
    // 抢红包 m为红包金额数， n 为个数,精确到分
    public static Map robLuckMoney(double m , int n ){
        HashMap<String , Double> map  =  new HashMap((int)(n/0.75));
        Random random = new Random();
        double remainMoney = m;
        double max;
        double min = 0.01 ;
        for (int i = 1 ; i <= n ; i++){
            if (i==n){
                map.put("A"+i,remainMoney);
                return map;
            }

            max = remainMoney / (n-i+1) * 2 ; // 最多为平均值的二倍
            double currentMoney = random.nextDouble() * max ;
            currentMoney = currentMoney < min ? min : currentMoney;

            // 保留两位小数最简单最直观的策略就是 乘以100 向下取整 再除以 100 。
            currentMoney = Math.floor(currentMoney*100)/100;

            map.put("A"+i,currentMoney);
            // 计算剩余金额时需要考虑浮点数运算精度丢失的问题
            remainMoney=new BigDecimal(remainMoney).subtract(new BigDecimal(currentMoney)).doubleValue();
        }
        return map;
    }

    public static void main(String[] args) {


        System.out.println(robLuckMoney(10.91,3));
    }
}
