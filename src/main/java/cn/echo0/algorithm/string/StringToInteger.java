package cn.echo0.algorithm.string;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/14/2017 09:46 AM
 */
public class StringToInteger {
    public static int stringToInteger(String str) {

        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        boolean isNegative = false;
        int currentIndex = 0;
        if (str.charAt(currentIndex) == '-') {
            isNegative = true;
            currentIndex++;
        } else if (str.charAt(currentIndex) == '+') {
            currentIndex++;
        }
        long result = 0;
        ;
        for (int length = str.length(); currentIndex < length; currentIndex++) {
            if (str.charAt(currentIndex) > '9' || str.charAt(currentIndex) < '0') {
                throw new IllegalArgumentException();
            }
            result = result * 10 + (str.charAt(currentIndex) - '0');
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                throw new IllegalArgumentException();
            }
        }
        return isNegative ? (int) -result : (int) result;
    }

    public static void main(String[] args) {
        System.out.println(stringToInteger("-7199"));
        System.out.println(stringToInteger("+7199000"));
    }
}
