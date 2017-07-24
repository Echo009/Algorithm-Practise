package cn.echo0.algorithm.tree;

import java.util.HashMap;

import static cn.echo0.algorithm.tree.ConstructBinaryTree.genBinaryTreeByPerOrderAndInorder;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/24/2017 02:20 PM
 */
public class HasSubTree {
    public static boolean hasSubTree(SimpleBinaryTreeNode tree, SimpleBinaryTreeNode subTree) {
        boolean result = false;
        if (tree != null && subTree != null) {
            if (tree.value == subTree.value) {
                result = doesTree1HasTree2(tree, subTree);
            }
            if (!result) {
                result = hasSubTree(tree.leftNode, subTree);
            }
            if (!result) {
                result = hasSubTree(tree.rightNode, subTree);
            }
        }
        return result;
    }

    private static boolean doesTree1HasTree2(SimpleBinaryTreeNode tree1, SimpleBinaryTreeNode tree2) {

        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.value != tree2.value) {
            return false;
        }
        return doesTree1HasTree2(tree1.leftNode, tree2.leftNode) && doesTree1HasTree2(tree1.rightNode, tree2.rightNode);

    }


    public static void main(String[] args) {
        int[] perOrder1 = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder1 = {4, 7, 2, 1, 5, 3, 8, 6};

        int[] perOrder2 = {1, 2, 4, 7};
        int[] inOrder2 = {4, 7, 2, 1};

        try {
            SimpleBinaryTreeNode tree = genBinaryTreeByPerOrderAndInorder(perOrder1, inOrder1);
            SimpleBinaryTreeNode subTree = genBinaryTreeByPerOrderAndInorder(perOrder2, inOrder2);
            System.out.println(hasSubTree(tree, subTree));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
