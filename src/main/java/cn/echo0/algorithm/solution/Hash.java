package cn.echo0.algorithm.solution;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/16/2017 10:53 AM
 */
public class Hash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> container =new HashSet<>(50);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] strings = str.split(" ");
            for (String temp : strings){
                container.add(temp);
            }
        }
        System.out.println(container.size());
    }
}
