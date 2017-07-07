package cn.echo0.algorithm.queue;

import java.util.Stack;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/7 16:44
 */
public class SQueue <T>{
    //使用栈实现队列
    private Stack<T> stack1 = new Stack();
    private Stack<T> stack2 = new Stack();
    public void offer(T value){
        stack1.push(value);
    }
    public T poll() throws Exception {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        else if(!stack1.isEmpty()&&stack2.isEmpty()){
            while (stack1.size()!=1){
                stack2.push(stack1.pop());
            }
            return  stack1.pop();
        }
        throw new Exception("Current queue is empty !");
    }

    public static void main(String[] args) throws Exception {
        SQueue queue = new SQueue();
        queue.offer("hope ");
        queue.offer("you ");
        queue.offer("happier !  ");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer("QAQ ~  ");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
