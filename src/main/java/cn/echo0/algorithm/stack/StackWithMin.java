package cn.echo0.algorithm.stack;

import java.util.Stack;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/25/2017 12:21 PM
 */
public class StackWithMin<T extends Comparable> {
    private Stack<T> data = new Stack();
    private Stack<T> min = new Stack();
    public T push(T t){
        data.push(t);
        if(min.empty()||min.peek().compareTo(t)>0){
           return min.push(t);
        }
        else {
            return min.push(min.peek());
        }
    }
    public T pop(){
        min.pop();
       return data.pop();
    }
    public T min(){
        return min.peek();
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(2);
        stackWithMin.push(3);
        stackWithMin.push(1);
        stackWithMin.push(0);
        stackWithMin.push(9);
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
    }
}
