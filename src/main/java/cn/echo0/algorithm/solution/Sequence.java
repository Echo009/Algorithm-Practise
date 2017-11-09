/*
*start code
*/
package cn.echo0.algorithm.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * Author : Echo0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 2017/10/11 20:33
 */
public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] operatedIndex ;
        int length = scanner.nextInt(); // 序列长度
        int n = scanner.nextInt(); // 操作次数
        operatedIndex = new int[n];
        Map map = new HashMap((n<<2)/3 + 1); // * 4 /3
        for (int i = n-1;i>=0;i--){
            operatedIndex[i]=scanner.nextInt();
            map.put(operatedIndex[i],true);
        }
        // output
        Map hasOutPut = new HashMap((n<<2)/3 + 1); // * 4 /3
        for (int i = 0; i < n; i++){
            if (hasOutPut.get(operatedIndex[i])==null){
                System.out.println(operatedIndex[i]);
                hasOutPut.put(operatedIndex[i],true);
            }
        }
        for (int i = 1 ; i <= length ; i++){
            if (map.get(i)!=null){
                continue;
            }
            System.out.println(i);
        }
    }
}
