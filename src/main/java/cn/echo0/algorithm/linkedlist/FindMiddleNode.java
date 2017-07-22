package cn.echo0.algorithm.linkedlist;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/22/2017 03:33 PM
 */
public class FindMiddleNode {
    //给定一个单向链表，找出链表中的中间节点。长度为偶数的话可以返回任意一个节点。
    public static ListNode findMiddleNode(ListNode list){
        if (list == null){
            return null;
        }
        ListNode perNode = list;
        ListNode backNode = list;
        while (backNode.next!=null&&backNode.next.next!=null){
            perNode = perNode.next;
            backNode=backNode.next.next;
        }
        return perNode;
    }

    public static void main(String[] args) {
        ListNode list= ListNode.genSimpleIntLinkedList(0);
        System.out.println(findMiddleNode(list));
    }
}
