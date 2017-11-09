    /*
    *start code
    */
    package cn.echo0.algorithm.solution;

    import java.util.Scanner;

    /**
     * Author : Echo0
     * Email  : ech0.extreme@foxmail.com
     * Time   : 2017/10/11 21:01
     */
    public class MaxNumOfBitSum {
        // dp

       static String findMaxNum(int currentLength, int perNum) {//
            if (currentLength==0){
                return "";
            }
            if (currentLength <= 2) {
                return currentLength+"";
            }

            long maxValue = Long.MIN_VALUE;
            for (int i = 1 ; (currentLength-i)>=0 && i <= 9 ; i++){
                if (i==perNum){ //相邻
                    continue;
                }
                long currentValue = Long.valueOf(i
                        + findMaxNum(currentLength-i,i)+"");
                if (maxValue < currentValue){
                    maxValue = currentValue;
                }

            }
            return maxValue+"";

        }

        public static void main(String[] args) {

           while (true){
               Scanner scanner = new Scanner(System.in);
               int n = scanner.nextInt();
               System.out.println(findMaxNum(n,-1));
           }


        }
    }
