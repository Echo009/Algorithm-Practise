package cn.echo0.algorithm.string;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/09/2017 10:26 AM
 */
public class ReverseOrderOfWords {
    public static void reverseOrderOfWords(String words ){
        if(words == null || words .length()==0){
            System.out.println( " IllegalArgument !");
            return;
        }
        String [] targets = words.split(" ");
        for (int i = targets.length-1 ; i >= 0;i-- )
        {
            System.out.print(targets[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        reverseOrderOfWords("Hey , You look so cute ! ");
    }
}
