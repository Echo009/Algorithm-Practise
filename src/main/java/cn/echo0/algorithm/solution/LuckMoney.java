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
    // 抢红包
    public static Map robLuckMoney(double m , int n ){
        HashMap<String , Double> map  =  new HashMap((int)(n/0.75));
        Random random = new Random();
        double remainMoney = m;
        for (int i = 1 ; i <= n ; i++){
            if (i==n){
                map.put("A"+i,(double)Math.floor(remainMoney*100)/100);
                return map;
            }
            double min = 0.01 ;
            double max = remainMoney / (n-i+1) * 2 ; // 最多为平均值的二倍
            double currentMoney = random.nextDouble() * max ;
            currentMoney = currentMoney < min ? min : currentMoney;
            currentMoney = Math.floor(currentMoney*100)/100;
            map.put("A"+i,currentMoney);
            remainMoney-=currentMoney;
        }
        return map;
    }

    public static void main(String[] args) {


        System.out.println(robLuckMoney(10,5));
    }
}
