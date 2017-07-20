package cn.echo0.algorithm.bit;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/20/2017 10:02 AM
 */
public class SimplePowerFuncition {
    public static double power(double base, int exponent) {

        if (base == 0) {
            return 0;
        }
        boolean isNegative = false;
        boolean reciprocal = false;
        if (base < 0 && (exponent & 1) == 1) { // negative
            isNegative = true;
            base=-base;
        }
        if (exponent < 0) {
            reciprocal = true;
            exponent=-exponent;
        }
        double result = powerUnsigned(base,exponent);
        if (reciprocal) {
            result = 1 / result;
        }
        if (isNegative) {
            return -result;
        } else return result;

    }
    private static double powerUnsigned(double base , int exponent){

        if (exponent==1){
            return base;
        }

        double result = power(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2,-3));
    }
}
