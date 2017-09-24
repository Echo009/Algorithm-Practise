package cn.echo0.algorithm.linkedlist;


import java.util.HashMap;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/22/2017 04:19 PM
 */
public class FindLoopEntrance {
    // 在一个存在环的链表中找到环的入口节点
//    ①先判断链表中是否存在环，并且找到环中的任意一个节点
    public static ListNode findAnyNodeOfLoop(ListNode list) {
        if (list == null) {
            return null;
        }
        ListNode slowNode = list.next;

        if (slowNode == null) {
            return null;
        }
        ListNode fastNode = slowNode.next;
        while (fastNode != null && slowNode != null) {
            if (fastNode == slowNode) {
                return fastNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode.next != null) {
                fastNode = fastNode.next;
            }
        }
        return null;
    }

    //    ②确定环的长度，找到环的入口
    public static ListNode findEntranceOfLoop(ListNode list) {
        ListNode nodeOfLoop = findAnyNodeOfLoop(list);
//        不存在环
        if (nodeOfLoop == null) {
            return null;
        }
//       ③ 得到环中节点的数量
        int loopLenth = 1;
        ListNode temp = nodeOfLoop.next;
        while (temp != nodeOfLoop) {
            temp = temp.next;
            loopLenth++;
        }
//        ④找入口
        ListNode node1 = list;
        ListNode node2 = list;
        while(loopLenth!=0){
            node2=node2.next;
            loopLenth--;
        }
        while(node1!=node2){
            node1=node1.next;
            node2=node2.next;
        }
        return node1;
    }

    public static ListNode genSimpleLoopList(int loopEntrance,int loopLength){
        if(loopEntrance > loopLength||loopEntrance<=0||loopLength<=0){
            return null;
        }
        ListNode listNode=new ListNode(1);
        ListNode loopEntranceNode =listNode;
        for (int i=2;i <= loopEntrance;i++){
            loopEntranceNode.next=new ListNode(i);
            loopEntranceNode=loopEntranceNode.next;
        }
        ListNode listTailNode = loopEntranceNode;
        for(int i=loopEntrance+1;i<=loopLength;i++){
            listTailNode.next=new ListNode(i);
            listTailNode=listTailNode.next;
        }
        listTailNode.next=loopEntranceNode;
        return listNode;
    }

    public static void main(String[] args) {
        System.out.println(findEntranceOfLoop(genSimpleLoopList(1, 10)).value);

    }
}
