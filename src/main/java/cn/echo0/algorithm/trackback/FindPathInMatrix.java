package cn.echo0.algorithm.trackback;

import java.util.Arrays;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/8 13:09
 */
public class FindPathInMatrix {
    //判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
    // 路径可以从矩阵的任意一格开始，每一步可以在矩阵的上下左右移动一格，但是不能重复进入某一格
    public static boolean containsPath(char[][] matrix,String str ){
        if(matrix==null || matrix.length == 0 ||str == null || matrix[0].length==0 ){
            return false ;
        }
        boolean [] visited = new boolean[matrix.length*matrix[0].length];
        for (int row = 0 ; row < matrix.length ;row++  ){
            for (int col = 0 ; col < matrix[0].length ; col ++ ){
                if(containsPathCore(matrix,str,row,col,visited,0)){
                    return true;
                }
            }
        }
        return false ;
    }
    public static boolean containsPathCore(char[][]matrix , String str ,int startRowIndex , int startColIndex,boolean[]visited , int currentIndex){
        if(currentIndex==str.length()){
            return true;
        }
        boolean hasPath = false ;
        if(startRowIndex < matrix.length
                && startColIndex < matrix[0].length
                && startColIndex >= 0
                && startRowIndex >= 0
                && visited[startRowIndex*matrix[0].length+startColIndex]!=true
                && str.charAt(currentIndex)==matrix[startRowIndex][startColIndex]){
            visited[startRowIndex*matrix[0].length+startColIndex]=true;
            currentIndex++;
            hasPath = containsPathCore(matrix,str,startRowIndex-1,startColIndex,visited,currentIndex)
                    ||containsPathCore(matrix,str,startRowIndex+1,startColIndex,visited,currentIndex)
                    ||containsPathCore(matrix,str,startRowIndex,startColIndex+1,visited,currentIndex)
                    ||containsPathCore(matrix,str,startRowIndex,startColIndex-1,visited,currentIndex);
            if(!hasPath){
                currentIndex--;
                visited[startRowIndex*matrix[0].length+startColIndex]=false;
            }

        }
        return hasPath;
    }

    public static void main(String[] args) {
       char[][] matrix = {  {'L','b','t','g'}
                                    , {'L','L','c','s'}
                                    , {'b','e','s','t'}};
        System.out.println(containsPath(matrix,"LLL"));
        System.out.println(containsPath(matrix,"e"));
        System.out.println(containsPath(matrix,"best"));

    }
}
