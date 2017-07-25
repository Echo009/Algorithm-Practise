package cn.echo0.algorithm.tree;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/24/2017 07:21 PM
 */
public class TreeMirror {
    //给定一个二叉树，将其镜像反转
    public static void mirrorRecursively(SimpleBinaryTreeNode tree){
        if (tree==null)
            return ;
        if(tree.leftNode==null&&tree.rightNode==null){
            return;
        }
//        镜像反转 当前节点
        SimpleBinaryTreeNode temp = tree.rightNode;
        tree.rightNode = tree .leftNode;
        tree.leftNode=temp;

        mirrorRecursively(tree.rightNode);
        mirrorRecursively(tree.leftNode);


    }
    public static boolean isSymmetrical(SimpleBinaryTreeNode tree){
        return isSymmetrical(tree,tree);
    }
    private static boolean isSymmetrical(SimpleBinaryTreeNode tree1,SimpleBinaryTreeNode tree2){
        if(tree1==null&&tree2==null){
            return true;
        }
        if(tree1==null||tree2==null){
            return false;
        }
        if(tree1.value!=tree2.value){
            return false;
        }
        return isSymmetrical(tree1.leftNode,tree2.rightNode)
                &&isSymmetrical(tree1.rightNode,tree2.leftNode);
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode treeNode = GenSimpleTree.getTree();
        mirrorRecursively(treeNode);
       ConstructBinaryTree.preOrder(treeNode);
        System.out.println(isSymmetrical(null));
    }
}
