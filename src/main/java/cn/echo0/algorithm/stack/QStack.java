package cn.echo0.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/7 16:13
 */
public class QStack<T> {

    // 使用两个队列实现栈
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T value) {
        queue1.add(value);
    }

    public T pop() throws Exception {
        if (queue1.size() != 0) {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else if (queue2.size() != 0) {
            while (queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        throw new Exception("Current stack is empty  !  ");
    }

    public static void main(String[] args) throws Exception {
        QStack stack = new QStack();
        stack.push("hope");
        stack.push("you");
        stack.push("happier");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("Ok ?  ");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
