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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        //base cases
        if(p==null && q==null)
        {
            return true;
        }

        //if any of the nodes is null
        if((p!=null && q==null)||(p==null && q!=null))
        {
            return false;
        }
        
        //if both of the nodes are not null
        if(p!=null && q!= null)
        {
            if(p.val == q.val)
            {
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
            //if not equal then come out of the outer if block and end the program with return statement
        } 

 return false;

    }
}