package tooffer;

import org.junit.Test;

/**
 * Created by unclexiao on 14/04/2018.
 */
public class ReConstructBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }



    @Test
    public void test(){
        int[] pre ={1,2,3,4};
        int[] in = {1,2,3,4};
        TreeNode root = reConstructBinaryTree(pre,in);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);

    }


    public TreeNode reConstructBinaryTree(int[] pre, int pl, int pr, int[] in, int il, int ir) {

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

        node.left = reConstructBinaryTree(pre, pl + 1, pl+index, in, il, il+index - 1);
        node.right = reConstructBinaryTree(pre, pl+index+1,pr, in, il+index+1, ir);

        return node;
    }
}
