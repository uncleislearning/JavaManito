package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unclexiao on 18/04/2018.
 */
public class SearchRange {



    private static class  TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> arrays = new ArrayList<>();
        inOrder(root,arrays,k1,k2);
        return arrays;
    }


    private void inOrder(TreeNode root,List<Integer> list,int k1,int k2){
        if(root == null){
            return;
        }
        inOrder(root.left,list,k1,k2);
        if(root.val>= k1 && root.val <=k2){
            list.add(root.val);
        }
        inOrder(root.right,list,k1,k2);
    }
}
