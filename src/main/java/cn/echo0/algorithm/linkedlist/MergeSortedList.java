package cn.echo0.algorithm.linkedlist;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/23/2017 12:26 PM
 */
public class MergeSortedList {
//    合并两个有序的链表
       public static ListNode mergeSortList(ListNode list1,ListNode list2){
           if(list1==null){
               return list2;
           }
           if(list2==null){
               return list1;
           }
           ListNode head = null;
           if((int)list1.value<=(int)list2.value){
               head = list1;
               head.next=mergeSortList(list1.next,list2);
           }else {
               head=list2;
               head.next=mergeSortList(list1,list2.next);
           }
           return head;
       }

    public static void main(String[] args) {
        System.out.println(mergeSortList(null,null));
        ListNode list1 = new ListNode(2);
        ListNode temp = new ListNode(4);
        list1.next=temp;
        ListNode list2 = new ListNode(1);
         temp = new ListNode(3);
         list2.next=temp;
        System.out.println(mergeSortList(list1,list2));
    }
}

