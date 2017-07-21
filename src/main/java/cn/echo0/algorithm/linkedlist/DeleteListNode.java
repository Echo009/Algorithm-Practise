package cn.echo0.algorithm.linkedlist;

import static cn.echo0.algorithm.linkedlist.ListNode.printLinkedList;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/21/2017 09:30 AM
 */
public class DeleteListNode {
    //    给定一个链表，和一个链表中的一个节点，请从链表中删除这个节点
    public static void deleteListNode(ListNode list, ListNode targetNode) throws Exception {
        if (list == null) {
            throw new Exception("list is empty !");
        } else if (list.next == null) {
            throw new Exception("need to delete the head of list !");
        }else if(targetNode.next==null){
            //删除末尾节点
            ListNode pre =list ;
            while (pre.next.next!=null){
                pre=pre.next;
            }
            pre.next=null;
            return;
        }
        //将下一个节点的值复制到当前节点，并删除下一个节点
        ListNode next = targetNode .next;
        targetNode.next=next.next;
        targetNode.value=next.value;
        next.next=null;
    }

    public static void main(String[] args) throws Exception {
        ListNode list = ListNode.genSimpleIntLinkedList();
//        ListNode targetNode = list.next.next.next;
        ListNode targetNode = list ;
        while(targetNode.next!=null){
            targetNode=targetNode.next;
        }
        printLinkedList(list);
        deleteListNode(list,targetNode);
        System.out.println(targetNode);
        printLinkedList(list);
    }
}
