package cn.echo0.algorithm.string;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/21/2017 09:22 AM
 */
public class ReverseStringUseRecursive {

    public static String  reverse(String str){
        if (str==null||str.length()==1){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("lan"));
    }
}
