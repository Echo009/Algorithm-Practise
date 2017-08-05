package cn.echo0.algorithm.string;

import java.util.*;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/04/2017 12:38 PM
 */
public class FirstNotRepeatingChar {
    public static void findFirstNotRepeatingChar(String str ){
        if (str==null||str.length()==0){
            throw new IllegalArgumentException();
        }
        int [] table = new int[256];
        for (int i = 0 ; i < str.length();i++){
            table[str.charAt(i)]++;
        }
        for (int i = 0 ; i < str.length();i++){
            if (table[str.charAt(i)]==1){
                System.out.println(str.charAt(i));
                return;
            }
        }
        System.out.println(" no matched char !");
    }
    public static void findFirstNotRepeatingCharInStream(String str ){
        if (str==null||str.length()==0){
            throw new IllegalArgumentException();
        }
        Map map = new LinkedHashMap<Character,Integer>(26);
        for (int i = 0 ; i < str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),Integer.MIN_VALUE);
            }
            else map.put(str.charAt(i),1);
        }
        Set set = map.keySet();
        for (Object item : set){
            if((int) map.get(item) ==1){
                System.out.println(item);
                return;
            }
        }
        System.out.println(" no matched char !");
    }

    public static void main(String[] args) {
        findFirstNotRepeatingCharInStream("lovelanlana");
    }
}
