package cn.echo0.algorithm.tree;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/27/2017 02:25 PM
 */
public class VeritySquenceOfBST {
    /**
     * 判断该序列是否可能是一颗二叉树的后序遍历,该序列中没有重复节点
     * @param squence
     * @return
     */
    public static boolean verifySquenceOfBST(int[] squence){
        if(squence==null||squence.length==0){
            return false;
        }
        return  verifySquenceOfBST(squence,0,squence.length-1);
    }
    public static boolean verifySquenceOfBST(int[] squence,int start,int end){
        int root = squence[end];
        int i=start;
        for (;i<end;i++){
            if(squence[i]>root){
                break;
            }
        }
        int j=i;
        for (;j<end;j++){
            if(squence[j]<root){
                return false;
            }
        }
        boolean left = true;
        if(i>start){
            left=verifySquenceOfBST(squence,start,i-1);
        }
        boolean right =true;
        if(j<end){
            right =verifySquenceOfBST(squence,i,end-1);
        }
        return left&&right;
    }

    public static void main(String[] args) {
        System.out.println(verifySquenceOfBST(new int[]{5,7,6,9,11,10,8}));
        System.out.println(verifySquenceOfBST(new int[]{7,4,6,5}));
    }
}
