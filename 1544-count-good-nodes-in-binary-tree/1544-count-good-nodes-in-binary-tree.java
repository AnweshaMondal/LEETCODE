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
    public int goodNodes(TreeNode root) {

        if(root ==  null){
           return 0;
        }

       int maxVal = root.val;
       return 1+ helper(root.left,maxVal) + helper(root.right,maxVal);    //1 for the root node
    }



    int helper(TreeNode root , int maxVal){
          
          if(root ==  null){
            return 0;
          }

          if(root.val>= maxVal){
            maxVal = root.val;
            return 1+ helper(root.left,maxVal)+ helper(root.right,maxVal);
          }
          
          else{
            //ie root.val < maxval
            return helper(root.left,maxVal)+ helper(root.right,maxVal);
          }

    }
}