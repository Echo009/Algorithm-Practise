package cn.echo0.algorithm.number;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/18/2017 04:30 PM
 */
public class NthPrime {
    private static boolean isPrime(long num, ArrayList<Long> list) {
        if (num == 1) {
            return false;
        }
        long max = (long) Math.sqrt(num);
        for (long factor : list) {
            if (num % factor == 0) {
                return false;
            }
            if (factor > max) {
                break;
            }
        }
        return true;
    }

    public static long getNthPrime(int n) {
        if (n <= 0) {
            return -1;
        }
        ArrayList<Long> list = new ArrayList<>();
        long start = 1;
        while (list.size() < n) {
            if (isPrime(start, list)) {
                list.add(start);
            }
            start++;
        }
        return --start;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getNthPrime(n));
    }
}
