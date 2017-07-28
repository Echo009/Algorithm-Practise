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
    // 反转输出一个单向链表   , 利用递归实现
    public static void printReversedListRecursive(ListNode list) {
        if (list.next != null) {
            printReversedListRecursive(list.next);
        }
        System.out.print(list.value+" ");
    }
//    反转一个链表
    public static ListNode reverseList(ListNode list){
        if(list == null){
            return null;
        }
        ListNode reversedList = null;
        ListNode currentNode = list;
        ListNode perNode = null;
        while (currentNode!=null){
            ListNode nextNode =currentNode.next;
            if(nextNode==null){
                reversedList = currentNode;
            }
            currentNode.next=perNode;

            perNode=currentNode;
            currentNode=nextNode;
        }
        return reversedList;
    }
    public static void main(String[] args) {
//        printReversedLinkedList(ListNode.genSimpleIntLinkedList());
        System.out.println("");
        printReversedListRecursive(ListNode.genSimpleIntLinkedList());
        System.out.println(reverseList(ListNode.genSimpleIntLinkedList()));
    }
}
