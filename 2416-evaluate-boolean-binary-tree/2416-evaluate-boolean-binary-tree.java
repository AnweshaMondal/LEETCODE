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
    public boolean evaluateTree(TreeNode root) {
     
    //    boolean result = false;
       boolean val1 = false;
       boolean val2 = false;

       if(root == null) return false;
       //reached leaf node
       if(root.left == null && root.right == null) 
       {
         if(root. val == 1) return true;
         return false;
       }

    //  //As this is full BT , there won't be any case of 1 child = null
    //    if(root.left.val== 1|| root.left.val == 0)
    //    {     
    //     if(root.val == 1)
    //       {
    //         boolean val1 = ture;
    //       }
    //    }

    //    if(root.right.val== 1|| root.right.val == 0)//reached leaf node
    //    {     
    //     if(root.right.val == 1)
    //       {
    //         boolean val2 = ture;
    //       }
    //    }
   
    //  if it is not a leaf node
    val1 = evaluateTree(root.left);
    val2 = evaluateTree(root.right);

    if(root.val == 2) 
     return val1 || val2;
    
    else
    {
     return val1 && val2;
    } 

    }
}