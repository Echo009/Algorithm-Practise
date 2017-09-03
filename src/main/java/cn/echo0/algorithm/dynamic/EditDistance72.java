package cn.echo0.algorithm.dynamic;

import java.util.Arrays;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/03/2017 09:07 AM
 */
public class EditDistance72 {
//    Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

//    You have the following 3 operations permitted on a word:

//    a) Insert a character
//    b) Delete a character
//    c) Replace a character
    private static int dp[][];

    public static int minDistanceCore(int index1, int index2, String word1, String word2) {
        if (index1 == word1.length() && index2 == word2.length()) {
            return 0;
        }
        if (index1==word1.length()){
            return word2.length()-index2;//注意此时的index2并没有被处理
        }
        if (index2==word2.length()){
            return word1.length()-index1;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (word1.charAt(index1) == word2.charAt(index2)) { //字母相同则不需要操作
            dp[index1][index2] = minDistanceCore(index1 + 1, index2 + 1, word1, word2);
            return dp[index1][index2];
        } else {
            //insert into word1 or delete word2
            int resultOfInsertInto1 = minDistanceCore(index1, index2 + 1, word1, word2) + 1;
            //insert into word2 or delete word1
            int resultOfInsertInto2 = minDistanceCore(index1 + 1, index2, word1, word2) + 1;
            //replace
            int resultOfReplace = minDistanceCore(index1 + 1, index2 + 1, word1, word2) + 1;
            int result = resultOfInsertInto1 < resultOfInsertInto2 ? resultOfInsertInto1 : resultOfInsertInto2;
            result = result < resultOfReplace ? result : resultOfReplace;
            dp[index1][index2] = result;
            return result;
        }

    }

    public static int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++)
            Arrays.fill(dp[i], -1);

        return minDistanceCore(0, 0, word1, word2);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("abdabd", "abdaabd"));
    }
}
