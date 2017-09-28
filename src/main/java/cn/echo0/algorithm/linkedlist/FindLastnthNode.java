package cn.echo0.algorithm.linkedlist;

import static cn.echo0.algorithm.linkedlist.ListNode.genSimpleIntLinkedList;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 09/29/2017 12:09 AM
 */
public class FindLastnthNode {
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null ){
            return  null ;
        }
        ListNode fastNode = head ;
        while (k>1){
            fastNode = fastNode.next;
            if (fastNode==null){
                return null;
            }
            k--;
        }
        if(k!=1){
            return null;
        }
        while (fastNode.next!=null){
            fastNode = fastNode.next;
            head=head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = genSimpleIntLinkedList(5);
        System.out.println(findKthToTail(listNode,5));
    }
}
