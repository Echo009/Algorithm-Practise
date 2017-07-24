package cn.echo0.algorithm.tree;

import static cn.echo0.algorithm.tree.ConstructBinaryTree.genComplexBinaryTreeByPerOrderAndInorder;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/24/2017 07:28 PM
 */
public class GenSimpleTree {
    private static int[] perOrder = {1, 2, 4, 7, 3, 5, 6, 8};
    private static int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
    private static SimpleBinaryTreeNode tree;

    static {
        try {
            tree = genComplexBinaryTreeByPerOrderAndInorder(perOrder, inOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SimpleBinaryTreeNode getTree(){
        return tree;
    }

}
