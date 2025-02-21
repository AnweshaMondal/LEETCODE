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
    public int findSecondMinimumValue(TreeNode root) {
         
        if(root == null) return -1;
        int min = root.val;
        return dfs(root,min);
    }

    int dfs(TreeNode node, int min){
        
        if(node == null) return -1;
        if(node.val>min) return node.val;
        int left = dfs(node.left, min);
        int right = dfs(node.right, min);

        if(left == -1) return right;
        if(right == -1) return left;
        
        return Math.min(left,right);
    }
}