package cn.echo0.algorithm.tree;

import java.util.Arrays;

import static cn.echo0.algorithm.tree.GenSimpleTree.getTree;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/28/2017 09:40 PM
 */
public class SerializeATree {

    static void serializeATree(SimpleBinaryTreeNode tree, StringBuilder sequence) {
        serializeTree(tree, sequence);
        sequence.deleteCharAt(sequence.lastIndexOf(","));
    }

    static void serializeTree(SimpleBinaryTreeNode tree, StringBuilder sequence) {
        if (tree == null) {
            sequence.append("$,");
            return;
        }
        sequence.append(tree.value + ",");
        serializeTree(tree.leftNode, sequence);
        serializeTree(tree.rightNode, sequence);
        return;
    }
    static int index=0;
    static SimpleBinaryTreeNode deserializeTree( String[] sequence) {
        if(sequence==null||sequence.length==0){
            return null;
        }
        return deserializeTree_(sequence);
    }
    private static SimpleBinaryTreeNode deserializeTree_(String []sequence ){
        if(sequence[index].equals("$")){
            index++;
            return null;
        }
        SimpleBinaryTreeNode treeNode = new SimpleBinaryTreeNode(Integer.parseInt(sequence[index]));
        index++;
        treeNode.leftNode=deserializeTree_(sequence);
        treeNode.rightNode=deserializeTree(sequence);
        return treeNode;
    }

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        serializeATree(getTree(), result);
        System.out.println(result.toString());
        String[] sequence = result.toString().split(",");
        System.out.println(Arrays.toString(sequence));
        SimpleBinaryTreeNode tree = deserializeTree(sequence);
        PrintTree.printTree(tree);
    }
}
