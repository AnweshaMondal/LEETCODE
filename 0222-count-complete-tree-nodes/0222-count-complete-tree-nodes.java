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
    public int countNodes(TreeNode root) {
        int count = 0;
        return dfs(root, count);
    }
    
    int dfs(TreeNode root, int count){
          
        if(root == null) return count;
        count++;
        count = dfs(root.left,count);
        count = dfs(root.right,count);

        return count;
    }
}