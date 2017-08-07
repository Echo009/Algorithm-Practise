package cn.echo0.algorithm.tree;

import static cn.echo0.algorithm.tree.GenSimpleTree.getTree;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/07/2017 09:26 AM
 */
public class BlanceTree {
//    判断一棵树是否是平衡二叉树
    public static boolean isBlanceTree(SimpleBinaryTreeNode tree){
        Integer i = new Integer(0);
        return isBlanceTree(tree,i);
    }
    private static boolean isBlanceTree(SimpleBinaryTreeNode tree,Integer depth){

        if (tree==null){
            depth=0;
            return true;
        }
        Integer left=0 , right=0 ;
        if(isBlanceTree(tree.rightNode,right)&&isBlanceTree(tree.leftNode,left)){
            int diff = right -left;
            if(diff<=1&&diff>=-1){
                depth = 1+ (left>right?left:right);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isBlanceTree(getTree()));
    }
}
