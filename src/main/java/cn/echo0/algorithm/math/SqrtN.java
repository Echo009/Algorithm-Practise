package cn.echo0.algorithm.math;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/25/2017 07:31 AM
 */
public class SqrtN {
    // 求根号N
    public static float sqrt(int n){
        float percision = 0.01f;
        float min = 0.0f;
        float max = n;
        float mid , delta = 0.0f;
        while (true){
            mid=(min+max)/2;
            delta = mid*mid - n;
            if (delta<-percision){
                min = mid;
            }else if(delta>percision){
                max=mid;
            }else return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(sqrt(9));
    }
}
