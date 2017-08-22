package cn.echo0.algorithm.dynamic;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/22/2017 04:57 PM
 */
public class HouseRobber198 {

    private static int [] result ;
    public static int solve(int index , int [] nums){
        if(index<0){
            return 0;
        }
        if(result[index]>=0){
            return result[index];
        }
        result[index]=Math.max(nums[index]+solve(index-2,nums) , solve(index-1,nums));
        return result[index];
    }
    public static int rob(int[] nums) {
        int length = nums.length;
        result = new int [length];
        //init
        for (int i = 0;i<length;i++){
            result[i] = -1;
        }
        return solve(length-1,nums);
    }
    public static int rob_circulation(int []nums){
        if(nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        result = new int [nums.length];

        result[0] = nums[0];
        result[1] = Math.max(nums[0],nums[1]);
        for (int i = 2 ; i < nums.length;i++){
            result[i]=Math.max(result[i-2]+nums[i],result[i-1]);
        }
        return result[nums.length-1];
    }

    public static void main(String[] args) {
        int []testData =new int[] {1,2,3,4};
        System.out.println(rob_circulation(testData));
    }
}
