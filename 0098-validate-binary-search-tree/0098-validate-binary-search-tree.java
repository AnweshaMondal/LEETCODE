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
    public boolean isValidBST(TreeNode root) {
        long MAX = Long.MAX_VALUE; 
        long MIN = Long.MIN_VALUE;

        return helper(root, MIN , MAX);
    }

    boolean helper(TreeNode root, long leftB, long rightB){

          boolean resultCurr = false;

          if(root == null){
            return true;
          }

          if(root.val>leftB && root.val<rightB){
             resultCurr = true;
          }
              
         return  (helper(root.left, leftB , root.val)&&
                  helper(root.right, root.val , rightB)&& 
                  resultCurr);
    }
}