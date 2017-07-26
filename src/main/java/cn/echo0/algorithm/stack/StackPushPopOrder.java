package cn.echo0.algorithm.stack;

import java.util.Stack;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/26/2017 09:02 AM
 */
public class StackPushPopOrder {
    //    给定一个压栈序列，和出栈序列，判断其出栈序列是否合法
    public static boolean stackPushPopOrder(int[] pushOrder, int[] popOrder) {
        if (popOrder.length != pushOrder.length) {
            return false;
        }
        int length = pushOrder.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0;
             popIndex < length ;
                ) {
            if (!stack.empty() && stack.peek() == popOrder[popIndex]) {
                stack.pop();
                popIndex++;
            } else if (popOrder[popIndex] != pushOrder[pushIndex]) {
                stack.push(pushOrder[pushIndex]);
                pushIndex++;
            } else {
                popIndex++;
                pushIndex++;
            }
        }
        if (stack.empty()){

            return true;
        }
        System.out.println(stack.peek());
        return false;
    }

    public static void main(String[] args) {
        int [] pushOrder = new int[]{1,2,3,4,5};
        int [] popOrder = new int[]{2,1,4,5,3};
        System.out.println(stackPushPopOrder(pushOrder,popOrder));
    }
}
