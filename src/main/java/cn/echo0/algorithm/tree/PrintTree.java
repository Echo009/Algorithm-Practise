package cn.echo0.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static cn.echo0.algorithm.tree.GenSimpleTree.getTree;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/26/2017 09:32 AM
 */
public class PrintTree {
    public static void printTreeFromTopToBottom(SimpleBinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue queue = new LinkedList();
        // init
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            SimpleBinaryTreeNode tempNode = (SimpleBinaryTreeNode) queue.poll();

            System.out.print(tempNode.value+" ");
            if (tempNode.rightNode != null)
                queue.offer(tempNode.rightNode);
            if (tempNode.leftNode != null)
                queue.offer(tempNode.leftNode);

        }
    }
    public static void printTreeFromTopToBottomLineByLine(SimpleBinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Queue queue = new LinkedList();
        // init
        queue.add(treeNode);
        int nextLevel=0;
        int toBePrinted=1;
        while (!queue.isEmpty()) {
            SimpleBinaryTreeNode tempNode = (SimpleBinaryTreeNode) queue.poll();

            System.out.print(tempNode.value+" ");
            if (tempNode.rightNode != null){
                queue.offer(tempNode.rightNode);
                nextLevel++;
            }
            if (tempNode.leftNode != null){
                queue.offer(tempNode.leftNode);
                nextLevel++;
            }

            toBePrinted--;
            if(toBePrinted==0){
                System.out.println();
                toBePrinted=nextLevel;
                nextLevel=0;
            }
        }
    }
    public static void printTree(SimpleBinaryTreeNode treeNode){//之字型打印一颗树
        if(treeNode==null){
            return;
        }
        Stack[]stack = new Stack[2];
        stack[0]=new Stack();
        stack[1]=new Stack();
        stack[0].push(treeNode);
        int current=0;
        int next = 1 ;
        while (!stack[current].empty()||!stack[next].empty()){
            SimpleBinaryTreeNode temp =(SimpleBinaryTreeNode) stack[current].pop();
            System.out.print(temp.value+" ");

            if(current==0){
                if(temp.leftNode!=null){
                    stack[next].push(temp.leftNode);
                }
                if(temp.rightNode!=null){
                    stack[next].push(temp.rightNode);
                }
            }else {
                if(temp.rightNode!=null){
                    stack[next].push(temp.rightNode);
                }
                if(temp.leftNode!=null){
                    stack[next].push(temp.leftNode);
                }
            }
            if(stack[current].empty()){
                System.out.println();
                current^=next;
                next^=current;
                current^=next;
            }
        }
    }
    public static void main(String[] args) {
        printTreeFromTopToBottomLineByLine(getTree());
        printTree(getTree());
    }
}
