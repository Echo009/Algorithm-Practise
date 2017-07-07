package cn.echo0.algorithm.tree;

/**
 * Email     : ech0.extreme@foxmail.com
 * Author   : Ech0
 * Time      : 2017/7/6 16:24
 */
public class FindNextNode {
    // 找出二叉树中序遍历序列的下一个节点
    public static ComplexBinaryTreeNode findNextInOrderNode(ComplexBinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        //如果右子节点不为空，那么下一个节点为右子树的最左的那个节点
        if (node.rightNode!=null){
            ComplexBinaryTreeNode next = (ComplexBinaryTreeNode) node.rightNode ;
            while (next.leftNode!=null){
                next = (ComplexBinaryTreeNode) next.leftNode;
            }
            return next;
        }
        //如果右子节点为空，①且该节点是它父节点的左子节点那么，下一个节点就是 它的父节点。
        if(node.parentNode!=null&&node.parentNode.leftNode == node){
            return (ComplexBinaryTreeNode) node.parentNode ;
        }
        //②如果是它父节点的右子节点 ， 那么下一个节点 是它的上级节点，并且 这个节点必须是它父节点的左子节点 。
        if(node.parentNode!=null&&node.parentNode.rightNode==node){
            ComplexBinaryTreeNode next =(ComplexBinaryTreeNode) node.parentNode ;
            while (next.parentNode.leftNode!=next.parentNode){
                if(next.parentNode==null){
                    return null;  //说明该节点已经是中序遍历的最后一个节点
                }
                next =( ComplexBinaryTreeNode )next.parentNode ;
            }
        }
        return null;
    }
    private static int[] perOrder = {1, 2, 4, 7, 3, 5, 6, 8};
    private static int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
    public static void main(String[] args) throws Exception {
        ComplexBinaryTreeNode tree = ConstructBinaryTree.genComplexBinaryTreeByPerOrderAndInorder(perOrder,inOrder);
        System.out.println(findNextInOrderNode(tree).value);
        System.out.println(findNextInOrderNode(null));
    }
}
