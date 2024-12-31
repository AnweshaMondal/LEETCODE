/*
 *
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //edge case
        if(root == null) {
            return false;
        }

        int currSum = 0;
        return dfs(root, targetSum , currSum);
        
    }

//dfs function
    boolean dfs(TreeNode root, int targetSum,  int currSum){
           
          if (root == null) {
            return false; // If we reach a null node, this path does not lead to a solution
        }
           
               
        currSum += root.val;

         // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            return currSum == targetSum;
        }
               
               boolean result1 = dfs(root.left, targetSum,currSum);
               boolean result2 = dfs(root.right, targetSum,currSum);
               
               return (result1 || result2) ;
    } 
}