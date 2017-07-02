/*
 * Author : Echo0 
 * Email  : ech0.extreme@foxmail.com
 * Time   : Jul 2, 2017 1:11:55 PM
 */
package cn.echo0.algorithm.linkedlist;

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

    public static void main(String[] args) {
        ListNode intList  = genSimpleIntLinkedList() ;
        for(ListNode temp = intList ;temp!=null;temp=temp.next){
            System.out.println(temp.value);
        }
    }
}
