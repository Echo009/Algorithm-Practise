package cn.echo0.algorithm.tree;

import static cn.echo0.algorithm.tree.GenSimpleTree.getTree;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/07/2017 09:08 AM
 */
public class TreeDepth {

    public static int  countTreeDepth(SimpleBinaryTreeNode tree){
        if (tree==null){
            return 0;
        }
        int left = countTreeDepth(tree.leftNode);
        int right = countTreeDepth(tree.rightNode);
        return left>right? left+1:right+1;
    }

    public static void main(String[] args) {
        System.out.println(countTreeDepth(getTree()));
    }
}
