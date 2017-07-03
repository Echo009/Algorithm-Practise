/*
 * Author : Echo0 
 * Email  : ech0.extreme@foxmail.com
 * Time   : Jul 3, 2017 1:40:26 PM
 */
package cn.echo0.algorithm.tree;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ech0
 */
public class ConstructBinaryTree {

    // 由二叉树的先序序列和中序序列生成二叉树 。
    public static SimpleBinaryTreeNode genBinaryTreeByPerOrderAndInorder(int[] perOrder, int[] inOrder) throws Exception {
        if (perOrder == null || inOrder == null || perOrder.length == 0 || inOrder == null) {
            return null;
        }
        return genBinaryTreeByPerOrderAndInorder(perOrder, 0, perOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public static SimpleBinaryTreeNode genBinaryTreeByPerOrderAndInorder(
            int[] perOrder, int perStart, int perEnd,
            int[] inOrder, int inStart, int inEnd
    ) throws Exception {
        SimpleBinaryTreeNode root = new SimpleBinaryTreeNode(perOrder[perStart]); // 先序遍历的第一个节点是根节点 
        if (perStart == perEnd) {
            if (inStart == inEnd && inOrder[inStart] == perOrder[perStart]) {
                return root;
            } else {
                throw new Exception("Invalid Input !");
            }
        }
        // 在中序遍历中找到根节点 
        int rootIndexOfInOrder = inStart;
        while (rootIndexOfInOrder <= inEnd && inOrder[rootIndexOfInOrder] != root.value) {
            rootIndexOfInOrder++;
        }
        if (rootIndexOfInOrder > inEnd) {
            throw new Exception("Invalid Input !");
        }
        int leftLength = rootIndexOfInOrder - inStart; //左子树序列长度
        int leftPreOrderEnd = perStart + leftLength; // 左子树先序序列的末尾下标
        if (leftLength > 0) {//构建左子树
            root.leftNode = genBinaryTreeByPerOrderAndInorder(perOrder, perStart + 1, leftPreOrderEnd, inOrder, inStart, rootIndexOfInOrder - 1);
        }
        if (inEnd - rootIndexOfInOrder > 0) {//构建右子树
            root.rightNode = genBinaryTreeByPerOrderAndInorder(perOrder, leftPreOrderEnd + 1, perEnd, inOrder, rootIndexOfInOrder + 1, inEnd);
        }
        return root;
    }

    private static int[] perOrder = {1, 2, 4, 7, 3, 5, 6, 8};
    private static int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

    public static void preOrder(SimpleBinaryTreeNode root) {
        System.out.print(root.value + "  ");
        if (root.leftNode != null) {
            preOrder(root.leftNode);
        }
        if (root.rightNode != null) {
            preOrder(root.rightNode);
        }
    }

    public static void main(String[] args) {
        try {
            SimpleBinaryTreeNode tree = genBinaryTreeByPerOrderAndInorder(perOrder, inOrder);
            preOrder(tree);
            System.out.println("");
        } catch (Exception ex) {
            Logger.getLogger(ConstructBinaryTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
