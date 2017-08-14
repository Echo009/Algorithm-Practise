package cn.echo0.algorithm.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/10/2017 02:43 PM
 */
public class FindMaxValueInWindow {
    //给定一个数组和滑动窗口的大小，求所有窗口的最大值
    public static void maxInWindow(int[] array, int size) {
        if (array == null || array.length == 0 || size <= 0) {
            throw new IllegalArgumentException();
        }
        Deque queue = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (queue.isEmpty()) {
                queue.add(i);
            } else if (array[i] > array[(int) queue.peekFirst()]) { // 比队头的元素大
                queue.clear();
                queue.add(i);
            } else {
                while (array[(int) queue.peekLast()] <= array[i]) {// 从队尾移除比当前元素小的
                    queue.pollLast();
                }
                queue.addLast(i);
            }
            while ((int) queue.peekFirst() < i - size + 1) {
                queue.pollFirst();
            }
            if (i >= size - 1) {
                System.out.print(array[(int) queue.peekFirst()] + " ");
            }

        }

    }

    public static void main(String[] args) {
        maxInWindow(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
    }

}
