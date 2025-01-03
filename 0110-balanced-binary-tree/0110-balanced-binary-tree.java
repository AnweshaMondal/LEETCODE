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
    public boolean isBalanced(TreeNode root) {
        // A helper function that calculates the height of a tree
        // and checks if the tree is balanced
        return checkHeight(root) != -1;
    }
    
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: empty tree has height 0
        }
        
        // Recursively check the height of left and right subtrees
        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);
        
        // If either subtree is unbalanced, propagate -1 up the call stack
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Unbalanced
        }
        
        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
