package lintcode;

import java.io.*;

import java.util.LinkedList;


/**
 * Created by unclexiao on 15/04/2018.
 */
public class SerializeDeSerializeBinaryTree {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    //根据前序和中序 可以唯一确定一颗树

    public String serialize(TreeNode root) throws IOException {
        // write your code here
        if(root == null){
            return "null";
        }
        //保留遍历的节点
        StringBuilder sb  = new StringBuilder();
        LinkedList<Integer> pre = new LinkedList();
        preOrder(root,pre);
        LinkedList<Integer> in = new LinkedList();
        inOrder(root,in);

        for(int i=0;i<pre.size()-1;i++){
            sb.append(pre.get(i)).append(",");
        }
        sb.append(pre.get(pre.size()-1)).append(";");


        for(int i=0;i<in.size()-1;i++){
            sb.append(in.get(i)).append(",");
        }
        sb.append(in.get(in.size()-1));

        return String.valueOf(sb);
    }


    private int[] ltoA(String[] list){
        int[] a = new int[list.length];
        for(int i =0; i<list.length;i++){
            a[i] = Integer.valueOf(list[i]);
        }
        return a;
    }

    private void preOrder(TreeNode root,LinkedList pre){
        if(root == null)
            return;
        System.out.println(root.val);
        pre.add(root.val);
        preOrder(root.left,pre);
        preOrder(root.right,pre);
    }


    private void inOrder(TreeNode root,LinkedList in){
        if(root == null)
            return;
        System.out.println(root.val);

        inOrder(root.left,in);
        in.add(root.val);
        inOrder(root.right,in);
    }




    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) throws IOException, ClassNotFoundException {
        // write your code here
        //切分出 前序序列、中序序列
        if(data.equals("null")){
            return null;
        }

        String[] items = data.split(";");

        String[] preStr = items[0].split(",");
        String[] inStr = items[1].split(",");
        int[] pre = ltoA(preStr);
        int[] in = ltoA(inStr);

        //根据前、中序 构造二叉树
        return deserialize(pre,0,pre.length-1,in,0,in.length-1);

    }



    private TreeNode deserialize(int[] pre,int pl,int pr,int[] in,int il,int ir){
        if (pl > pr || il > ir ) {
            return null;
        }


        int value = pre[pl];
        TreeNode node = new TreeNode(value);

        int index = 0;//记录左子树节点个数

        for (int j = il; j <= ir; j++) {
            if (value != in[j]) {
                index++;
            }else {
                break;
            }

        }

        node.left = deserialize(pre, pl + 1, pl+index, in, il, il+index - 1);
        node.right = deserialize(pre, pl+index+1,pr, in, il+index+1, ir);

        return node;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerializeDeSerializeBinaryTree sb = new SerializeDeSerializeBinaryTree();

        TreeNode root = sb.init();

        String res =  sb.serialize(root);
        TreeNode r = sb.deserialize(res);
        sb.preOrder(r,new LinkedList());
    }

    public TreeNode init(){
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);

        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        return root;
    }


}
