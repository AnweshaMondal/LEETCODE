/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
           return true;
        }
        return isSameTree(root.left, root.right);
    }

    boolean isSameTree(TreeNode r1, TreeNode r2){
           
           if(r1 == null && r2 == null)
           {
             return true;
           }

           //if any of the nodes is null and the other is not
            if( (r1 ==  null && r2!= null) || (r1 != null && r2== null) )
           {
            return false;
           }

           if(r1 != null && r2 != null)
           {
            if(r1.val!= r2.val)
            {
                return false;
            }

            return isSameTree(r1.left,r2.right) && isSameTree(r1.right,r2.left);
           }

           return false;
    }
}