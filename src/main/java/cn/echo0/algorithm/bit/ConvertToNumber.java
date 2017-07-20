package cn.echo0.algorithm.bit;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/20/2017 08:59 AM
 */
public class ConvertToNumber {
    public static int converTonumber(String str){
        if (!checkStr(str)){
            return 0;
        }
        int sum = 0;
        for (int i=0,len=str.length();i<len;i++){
            sum += Math.pow(Math.pow(26,len-1-i),str.charAt(i)-'A'+1);
        }
        return sum;
    }
    public static boolean checkStr(String str){
        if (str==null||str.length()==0){
            return false;
        }
        for ( int i = str.length()-1;i>=0;i--){
            if (str.charAt(i)-'A'>25||str.charAt(i)-'A'<0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(converTonumber("AA"));
    }
}
