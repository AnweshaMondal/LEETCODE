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
    public int findTilt(TreeNode root) {
     
     if(root ==null) return 0;
      int sum = 0;
      int tilt = Math.abs(sumOfSubTree(root.left)-sumOfSubTree(root.right)); 
      sum+= tilt;
      sum+=findTilt(root.left);
      sum+=findTilt(root.right);
      return sum;
    
    }


    int sumOfSubTree(TreeNode root){
        
        if(root == null)return 0;
        int sum = 0;
        sum+=root.val;
        sum+=sumOfSubTree(root.left);
        sum+=sumOfSubTree(root.right);

        return sum;
    }
}