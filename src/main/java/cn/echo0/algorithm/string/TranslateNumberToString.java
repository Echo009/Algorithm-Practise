package cn.echo0.algorithm.string;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/02/2017 04:46 PM
 */
public class TranslateNumberToString {
//    给定一个数字，我们按照0-25对应于a-z的规则将其翻译成字符串，问最多有多少种翻译方式？
//    如 12258  有 五种
//    显然 如果用f(i)表示从第i个数字开始的不同翻译数目，那么有 f(i) = f(f+1)+check(i,i+1)*f(i+2);
//    check(i,i+1) 第i位 和第i+1位的数字组合∈[10,25]时，返回1 ，否则返回0
    public static int countWaysOfTranslation(int num){
        if (num<0){
            throw new IllegalArgumentException();
        }
        String str = String.valueOf(num);
        return countWaysOfTranslation(str,0);
    }
    private  static int countWaysOfTranslation(String str,int index){//recursive
        if(index==str.length()-1){
            return 1;
        }
        if (check(str,index)==1){
            return countWaysOfTranslation(str,index+1)+countWaysOfTranslation(str,index+2);
        }else
            return countWaysOfTranslation(str,index+1);
    }
    private static int check(String str,int index){
        int firNum = str.charAt(index)-'0';
        int secNum = str.charAt(index+1)-'0';
        int num = firNum*10+secNum;
        return num>=10&&num<=25 ? 1 : 0;
    }
    public static int countWaysOfTranslation_circulation(int num){
        if (num<0){
            throw new IllegalArgumentException();
        }
        String str = String.valueOf(num);
//        f(i) = f(f+1)+check(i,i+1)*f(i+2);
//        自下而上求解
        int count = 0 ;
        int counts[] = new int[str.length()];
        for (int i = str.length()-1;i>=0;i--){
            if (i==str.length()-1){
                count = 1 ;
            }else count = counts[i+1];
            if(i+2<str.length()){
                if (check(str,i)==1){
                    count+=counts[i+2];
                }
            }
            counts[i]=count;
        }return counts[0];
    }
    public static void main(String[] args) {
        System.out.println(countWaysOfTranslation(12258));
        System.out.println(countWaysOfTranslation_circulation(12258));
    }
}
