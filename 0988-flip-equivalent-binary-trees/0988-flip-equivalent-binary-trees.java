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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        if(root1 == null && root2 == null)
        {
            return true;
        }

        //if any one of it is null
        if((root1 == null && root2 != null)||(root1 != null && root2 == null))
        {
            return false;
        }

        //if they are not equal
        if(root1.val != root2.val)
        {
              return false;
        }
        
        //if they are not flipped
        boolean noSwap = flipEquiv( root1.left, root2.left)&&flipEquiv(root1.right, root2.right);
        //if they have been flipped 
        boolean swap = flipEquiv( root1.left, root2.right)&&flipEquiv(root1.right, root2.left);
        
        return noSwap||swap;
    }
}