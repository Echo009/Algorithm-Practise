package cn.echo0.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

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
    public static void main(String[] args) {
        printTreeFromTopToBottom(getTree());
    }
}
