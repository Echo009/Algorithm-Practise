package cn.echo0.algorithm.Sequence;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/7 17:05
 */
public class FibonacciSequence {
    public static int getNthTermByRecursive(int n){
        return fibonacci(n);
    }
    public static int fibonacci(int n){
        if(n==0||n==1){
            return n;
        }
        else return fibonacci(n-1)+fibonacci(n-2);
    }
    public static int getNthTermByCycle(int n){
        if (n==1 || n==0){
            return n;
        }
        int currentItem = 1 ;
        int preItem = 0 ;
        for (int i = 2 ; i<=n ; i++ ){
            int temp = currentItem ;
            currentItem = preItem+currentItem ;
            preItem=temp;
        }
        return currentItem;
    }

    public static void main(String[] args) {
        long currentTime = System.nanoTime();
        System.out.println(getNthTermByRecursive(10));
        System.out.println((System.nanoTime()-currentTime)/Math.pow(10,6));
        currentTime= System.nanoTime();
        System.out.println(getNthTermByCycle(10));
        System.out.println((System.nanoTime()-currentTime)/Math.pow(10,6) );
    }
}
