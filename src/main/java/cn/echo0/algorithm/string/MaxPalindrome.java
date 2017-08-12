package cn.echo0.algorithm.string;



/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/12/2017 12:27 PM
 */
public class MaxPalindrome {
    public static int findMaxPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return -1; // no matched result
        }
        String reversedString = reverseString(str);
        return str.length()-lcs(str,reversedString);
    }

    public static int lcs(String str1, String str2) {//求两个字符串最长公共子序列
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] maxLength = new int[length1 + 1][length2 + 1]; //记录子问题解
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    maxLength[i][j] = maxLength[i - 1][j - 1] + 1;
                } else {
                    maxLength[i][j] =
                            maxLength[i - 1][j] > maxLength[i][j - 1] ? maxLength[i - 1][j] : maxLength[i][j - 1];

                }
            }
        }
        return maxLength[length1][length2];
    }
    private static String reverseString(String string){
        StringBuilder result = new StringBuilder(string.length());
        for (int i = string.length()-1;i>=0;i--){
            result.append(string.charAt(i));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(findMaxPalindrome("yyybbb"));

    }
}
