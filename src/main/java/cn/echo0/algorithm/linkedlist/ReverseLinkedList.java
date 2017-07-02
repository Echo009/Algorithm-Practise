/*
 * Author : Echo0 
 * Email  : ech0.extreme@foxmail.com
 * Time   : Jul 2, 2017 1:10:55 PM
 */
package cn.echo0.algorithm.linkedlist;

import java.util.Stack;

/**
 *
 * @author Ech0
 */
public class ReverseLinkedList {

    // 反转输出一个单向链表   , 利用栈实现
    public static void printReversedLinkedList(ListNode list) {
        Stack stack = new Stack();
        ListNode temp = list;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(((ListNode) stack.pop()).value+" ");
        }
    }

    public static void printReversedListRecursive(ListNode list) {
        if (list.next != null) {
            printReversedListRecursive(list.next);
        }
        System.out.print(list.value+" ");
    }

    public static void main(String[] args) {
//        printReversedLinkedList(ListNode.genSimpleIntLinkedList());
        System.out.println("");
        printReversedListRecursive(ListNode.genSimpleIntLinkedList());
    }
}
