package cn.echo0.algorithm.number;

import java.util.ArrayList;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 10/18/2017 02:39 PM
 */
public class LuckNumber {


    private static ArrayList<Integer> list = new ArrayList(1024);


    static { // init

        for(int i = 1 ; i < 10 ; i++){
            getLuckNums(i,list,0,"");
        }

    }
    // 十进制表示只含数字6和8的即为幸运数
    public static void getLuckNums(int targetLength, ArrayList<Integer> numList , int currentLen , String currentNumString ){

        if (targetLength==currentLen){
            numList.add(Integer.valueOf(currentNumString));
            return;
        }
        getLuckNums(targetLength,numList,
                currentLen+1,currentNumString+"6");
        getLuckNums(targetLength,numList,
                currentLen+1,currentNumString+"8");
    }

    public static int countOfLuckNum(int a , int b){
        int minIdx , maxIdx;
        for(minIdx = 0 ; minIdx < list.size(); minIdx++){
            if (list.get(minIdx)<a){
                minIdx++;
            }
            if (list.get(minIdx)>=a) break;
        }
        for(maxIdx = minIdx ; maxIdx < list.size(); maxIdx++){
            if (list.get(maxIdx)<=b){
                maxIdx++;
            }
            if (list.get(maxIdx)>b) {
                maxIdx--;
                break;
            }
        }
        return maxIdx-minIdx+1;
    }

    public static void main(String[] args) {
        System.out.println(countOfLuckNum(6,6));
    }


}
