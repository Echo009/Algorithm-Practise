package cn.echo0.algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/10/2017 03:25 PM
 */
public class QueueWithMaxFunction<T extends Comparable> {
    private Deque maxValues = new LinkedList<T>();
    private Queue queue = new LinkedList<T>();

    public boolean pushBack(T element) {
        try {
            queue.add(element);
            if (maxValues.isEmpty()) {// 最大值记录队列为空
                maxValues.addFirst(element);
            } else if (element.compareTo(maxValues.peekFirst()) > 0) { //比最大值还大
                maxValues.clear();
                maxValues.addFirst(element);
            } else {
                while (element.compareTo(maxValues.peekLast()) > 0) {// 从队尾移除比当前元素小的
                    maxValues.pollLast();
                }
                maxValues.addLast(element);//将当前元素添加到队尾
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public T popFront() {
        T temp = (T) queue.poll();
        if (temp.compareTo(maxValues.peekFirst()) == 0) { //移除的正好是队列中最大的元素
            maxValues.pollFirst(); //移除当前最大的值
        }
        return temp;
    }

    public T maxValueInQueue() {
        return (T) maxValues.peekFirst();
    }

    public static void main(String[] args) {
        QueueWithMaxFunction queueWithMaxFunction = new QueueWithMaxFunction();
        queueWithMaxFunction.pushBack(2);
        queueWithMaxFunction.pushBack(3);
        queueWithMaxFunction.pushBack(4);
        System.out.println(queueWithMaxFunction.maxValueInQueue());
        queueWithMaxFunction.pushBack(2);
        System.out.println(queueWithMaxFunction.maxValueInQueue());
        queueWithMaxFunction.popFront();
        queueWithMaxFunction.popFront();
        queueWithMaxFunction.popFront();
        System.out.println(queueWithMaxFunction.maxValueInQueue());
        queueWithMaxFunction.pushBack(5);
        queueWithMaxFunction.pushBack(7);
        System.out.println(queueWithMaxFunction.maxValueInQueue());

    }
}
