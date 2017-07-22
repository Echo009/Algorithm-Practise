/*
 * Author : Echo0 
 * Email  : ech0.extreme@foxmail.com
 * Time   : Jul 2, 2017 1:11:55 PM
 */
package cn.echo0.algorithm.linkedlist;

import java.util.List;

/**
 *
 * @author Ech0
 * @param <T>
 */
public class ListNode<T> {

    public T value;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(T value) {
        this.value = value;
        next = null;
    }

    @SuppressWarnings("unchecked")
    public static ListNode genSimpleIntLinkedList() {
        ListNode<Integer> intLIst = new ListNode(0);
        ListNode temp = intLIst ;
        for (int i = 1; i < 10; i++) {
             ListNode<Integer> newNode = new ListNode(i);
             temp.next = newNode ;
             temp = newNode ;
        }
        return intLIst;
    }
    public static ListNode genSimpleIntLinkedList(int n) {
        ListNode<Integer> intLIst = new ListNode(0);
        ListNode temp = intLIst ;
        for (int i = 1; i <= n; i++) {
            ListNode<Integer> newNode = new ListNode(i);
            temp.next = newNode ;
            temp = newNode ;
        }
        return intLIst;
    }
    public static void printLinkedList(ListNode list){
        for(ListNode temp = list ;temp!=null;temp=temp.next){
            System.out.print(temp.value+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode intList  = genSimpleIntLinkedList() ;
        printLinkedList(intList);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
