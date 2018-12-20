package com.xiao.JAVAManito.algorithm;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by unclexiao on 17/03/2018.
 */
public class TreeAlgorithm {


    /**
     * 树节点定义
     */

    private static class MTreeNode<T extends Comparable<T>> {
        T data;
        MTreeNode left;
        MTreeNode right;

        public MTreeNode() {
        }

        public MTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


//    private static class MTree<T extends Comparable<T>>{
//        private MTreeNode root;
//
//        public void insert(T x){
//            if(root == null){
//                root = new MTreeNode(x);
//                return;
//            }
//
//            if(root.data.compareTo(x)==0) return;
//
//            if(root.data.compareTo(x)<0){
//                MTreeNode incur = root;
//
//                while (incur.left!=null ){
//                    incur = incur.left;
//                }
//                if(incur.left == null)
//                    incur.left = new MTreeNode(x);
//                else if(incur.right == null)
//                    incur.right = new MTreeNode(x);
//
//            } else if (root.data.compareTo(x)>0){
//                MTreeNode incur = root;
//                while (incur.left!=null && incur.right!=null){
//                    incur = incur.left;
//                }
//
//            }
//
//        }
//    }

    public static void main(String[] args) {
        //构建一颗二叉树

        int[] num = new int[]{1, 4, 6, 2, 5};
        MTreeNode root = createBinarySearchTreeRecursively(num);
        root = insert(root,5);
        travelTreeOnLevel(root);
    }


    /**
     * 如何创建一颗完全二叉树？？？？
     *
     */
    public static MTreeNode createTree(int[] num, int index) {
        if (index > num.length || index <= 0) {
            return null;
        }
        MTreeNode temp = new MTreeNode(num[index - 1]); //当前节点
        temp.left = createTree(num, index * 2); //为它创建左孩子
        temp.right = createTree(num, index * 2 + 1);//为它创建右孩子
        return temp;
    }

    /**
     * 创建一颗二叉查找树？？非递归版
     *
     * @param
     */
    public static MTreeNode createBinarySearchTree(int[] num) {

        if (num == null || num.length <= 0)
            return null;

        MTreeNode root = new MTreeNode(num[0]);

        for (int i = 1; i < num.length; i++) {
            MTreeNode incur = root;
            while (incur != null) {
                if (incur.data.compareTo(num[i]) == 0)
                    break;
                else if (incur.data.compareTo(num[i]) < 0) {
                    if (incur.right == null) {
                        incur.right = new MTreeNode(num[i]);
                        break;
                    } else
                        incur = incur.right;
                } else {
                    if (incur.left == null) {
                        incur.left = new MTreeNode(num[i]);
                        break;
                    } else
                        incur = incur.left;
                }
            }
        }

        return root;
    }
    /**
     * 使用递归实现二叉树建立
     * @param num
     * @return
     */
    public static MTreeNode createBinarySearchTreeRecursively(int[] num){
        if (num == null || num.length <= 0)
            return null;

        MTreeNode root = null;
        for(int i=0;i<num.length;i++){
            root = insert(root,num[i]);
        }
        return root;
    }
    /**
     * 往二叉查找树中插入一个节点
     * @param
     * @param x
     */
    public static MTreeNode insert(MTreeNode root, int x) {
        if (root == null) {
            root = new MTreeNode(x);
            return root;
        }

        if (root.data.compareTo(x) == 0)
            return root;
        else if (root.data.compareTo(x) < 0) {
            root.right = insert(root.right, x);
        } else {
            root.left = insert(root.left, x);
        }
        return root;
    }

    /**
     * 中序递归遍历 二叉树
     * @param root
     */
    public static void travelTree(MTreeNode root) {
        if (root == null) {
            return;
        }

        travelTree(root.left);
        System.out.println(root.data);
        travelTree(root.right);
    }

    /**
     * 层序遍历二叉树
     */
    public static void travelTreeOnLevel(MTreeNode root){
        if(root == null)
            return;

        Queue tmp = new ArrayDeque();
        tmp.add(root);

        while (!tmp.isEmpty()){
            MTreeNode pre = (MTreeNode) tmp.poll();
            System.out.println(pre.data);


            if(pre.left!=null)
                tmp.add(pre.left);

            if(pre.right!=null)
                tmp.add(pre.right);
        }
    }
}
