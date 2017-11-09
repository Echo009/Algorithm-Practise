/*
*start code
*/
package cn.echo0.algorithm.solution;

import java.util.*;

/**
 * Author : Echo0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 2017/10/12 20:48
 */
public class MaxLengthOfVisit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] temp = input.split(",");
        int [] array;
        array = Arrays.stream(temp).mapToInt(s -> Integer.valueOf(s)).toArray();
        int num = array[0];
        int n = array[1];
//        System.out.println(num + "  " + n);
        List<TreeSet> treeSets = new LinkedList<>();

        for (int i = 0 ; i < n ; i ++ ){
            input = scanner.next();
            temp = input.split(",");
            array = Arrays.stream(temp).mapToInt(s -> Integer.valueOf(s)).toArray();
//            System.out.println(Arrays.toString(array));
           if (treeSets .isEmpty()){//init
               TreeSet set = new TreeSet();
               set.add(array[0]);
               set.add(array[1]);
           }else {
               for (TreeSet set : treeSets){
                   if (set.contains(array[0])&&set.contains(array[1]))
                   {
                       System.out.println("YES");
                   }
               }
           }
        }

    }

}
