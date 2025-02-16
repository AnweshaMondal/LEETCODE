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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null) //if root == null , there cannot be any sub tree
        {
            return false;
        }

        // if(isSameTree(root, subRoot))
        // {
        //     return true;
        // }

        // else //continue searching in children nodes also
        // {
        boolean result = isSameTree(root, subRoot);
        return result||isSubtree(root.left,subRoot)|| isSubtree(root.right,subRoot);
        // }

    }

    boolean isSameTree(TreeNode root,TreeNode subroot)
    {

        
        if(root ==  null && subroot != null || root!= null && subroot == null)
        {
            return false;
        }

        if(root == null && subroot == null)
        {
            return true;
        }

        else if(root!= null && subroot != null)
        {   
            if(root.val == subroot.val)
            {
             return isSameTree(root.left, subroot.left) && isSameTree(root.right, subroot.right);
        
            }
        }

        
            //ie the values of the nodes are not equal
              return false;   
        
    }
}