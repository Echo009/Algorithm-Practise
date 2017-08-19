package cn.echo0.algorithm.solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/19/2017 03:40 PM
 */
public class LuckyNumbers {
//    一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。
//    如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
//    例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
//    你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。
//    现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
    public static long dfs(int []array,int currentIndex, long sum , long product){
         int length = array.length;
         int count = 0;
        for (int i = currentIndex; i<length;i++ ){
             sum += array[i];
            product*=array[i];
             if (sum>product){
                count += 1 + dfs(array,i+1,sum,product);//继续搜索
            }else if(array[i]==1){
                count+=dfs(array,i+1,sum,product);
            }else break;//剪枝
             sum-=array[i];
            product/=array[i];
            while (i+1<length&&array[i]==array[i+1]){//去重
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []array= new int[n];
        for (int i = 0 ; i< n;i++){
            array[i]=in.nextInt();
        }
        Arrays.sort(array);
        System.out.println(dfs(array,0,0,1));
    }
}
