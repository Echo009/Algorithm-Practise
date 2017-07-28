package cn.echo0.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;

import static cn.echo0.algorithm.tree.GenSimpleTree.getTree;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/28/2017 07:58 PM
 */
public class FindPath {
    //给定一个树，和一个值，打印出所有节点值和为给定值的路径
    static void findPath(SimpleBinaryTreeNode tree, int value) {
        if (tree == null) {
            return;
        }
        LinkedList stack = new LinkedList();
        findPath(tree, value, 0, stack);
    }

    private static void findPath(SimpleBinaryTreeNode tree,
                                 int value, int currentValue,
                                 LinkedList stack) {
        stack.push(tree);
        currentValue += tree.value;
        if (tree.rightNode == null && tree.leftNode == null) {
            if (currentValue == value) {

                System.out.println(Arrays.toString(stack.toArray()));
            }else {
                stack.pop();
                return;
            }
        }
        if(tree.leftNode!=null){
            findPath(tree.leftNode,value,currentValue,stack);
        }
        if(tree.rightNode!=null){
            findPath(tree.rightNode,value,currentValue,stack);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        findPath(getTree(),14);
    }
}
