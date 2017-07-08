package cn.echo0.algorithm.trackback;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/8 19:38
 */
public class RobotMovingCount {
    // 给定一个 m*n的矩阵，一个机器人从（0,0）的位置出发，
    // 可以往上下左右移动一个格子，但是不可以进入行坐标和列坐标数位之和大于k的格子
    // 请计算 该机器人最多可以走过多少个格子
    public static int movingCount(int rows, int cols, int k) throws Exception {
        if (k < 0 || rows < 0 || cols < 0) {
            throw new Exception("Incorrect arguments ! ");
        }
        if (k == 0) {
            return 1;
        }
        boolean []visited = new boolean[rows*cols];
        int count = movingCountCore(0,0,rows,cols,k,visited);
        return count;
    }

    public static int movingCountCore(int row, int col, int rows, int cols, int k,boolean[]visited ) {
        int count = 0;
        if (row >= 0
                && row < rows
                && col >= 0
                && col < cols
                && isReachable(row,col,k)
                && !visited[row*cols+col]) {
            visited[row*cols+col]=true;
            count = 1 + movingCountCore(row + 1 ,col , rows , cols ,k ,visited)
                    + movingCountCore(row-1 ,col ,rows , cols ,k,visited)
                    + movingCountCore(row,col+1,rows ,cols ,k,visited )
                    + movingCountCore(row,col-1,rows,cols,k,visited);
        }
        return count;
    }

    private static boolean isReachable(int row, int col, int k) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum <= k;
    }

    public static void main(String[] args) throws Exception {
        System.out.println( movingCount(100,50,2));
    }
}
