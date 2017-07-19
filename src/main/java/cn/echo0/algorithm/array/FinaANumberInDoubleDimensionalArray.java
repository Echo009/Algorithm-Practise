/*
 * Author : Echo0 
 * Email  : ech0.extreme@foxmail.com
 * Time   : Jun 29, 2017 8:34:19 AM
 */
package cn.echo0.algorithm.array;

/**
 * @author Ech0
 */
public class FinaANumberInDoubleDimensionalArray {
    //    在一个二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按照从上到下递增的顺序排列
//    在这个数组中查找某个整数 
    public static boolean finaANumberInDoubleDimensionalArray(int[][] array, int targetNum) {
        if (array == null) {
            return false;
        }
        int rows = array.length;
        int columns;
        if (rows == 0) {
            return false;
        } else {
            columns = array[0].length;
        }
        if (columns == 0) {
            return false;
        }
        {//try to find the targetNum
            int row = 0;
            int column = columns - 1;
            while (row <= rows - 1 && column >= 0) {
                if (array[row][column] == targetNum) {
                    return true;
                } else if (array[row][column] > targetNum) {//pervious column
                    column--;
                } else {// next row
                    row++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[3][];
        array[0] = new int[]{1, 4, 6, 9};
        array[1] = new int[]{2, 10, 68, 77};
        array[2] = new int[]{5, 22, 55, 99};
        System.out.println(finaANumberInDoubleDimensionalArray(array, 5));
    }

}
