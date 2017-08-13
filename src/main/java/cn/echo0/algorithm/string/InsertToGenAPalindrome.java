package cn.echo0.algorithm.string;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/13/2017 08:11 PM
 */
public class InsertToGenAPalindrome {
    private static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0, j = length - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static int numOfSulotionsPalindrome(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        int maxTimes = str1.length() + 1;
        int result = 0;
        for (int i = 0; i < maxTimes; i++) {
            String temp;

            temp = str1.substring(0, i) + str2 + str1.substring(i, maxTimes - 1);

            if (isPalindrome(temp)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numOfSulotionsPalindrome("aba", "b"));
    }
}
