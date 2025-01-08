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
    public int sumNumbers(TreeNode root) {
    
        int sum = 0;
        return helper(root, sum);
    }

    int helper(TreeNode root, int sum){
          
          if(root == null){ // this case stands for if one of the children node is null, but the other one
            return 0;       // is not, ie the node is an intermediate node with 1 child only
          }

           sum = sum*10 + root.val;

           //if it is a root node
           if(root.left == null && root.right == null){
               return sum;
           } 

          //if it is not a root node
          int left_Tree = helper(root.left, sum);
          int right_Tree = helper(root.right, sum);

          return left_Tree + right_Tree ;
            
    }
}