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
        // int lh = height(root.left);
        // int rh = height(root.right);
        // return (Math.abs(lh-rh)>1) ;    // Unbalanced

        return height(root)!= -1;
    }

    int height(TreeNode root){

        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        if(lh == -1 || rh == -1) return -1; //Unbalanced
        if(Math.abs(lh-rh)>1)    return -1; // Unbalanced

        return Math.max(lh,rh)+1 ;
    }
}
//WRITE DEPTH FUNCTION AS HELPER FUNCTION
//IN THE GIVEN FUNCTION , CALCULATE THE DEPTH OF LEFT ANF RIGHT SUB TREE 
//CHECK IF (MATH.ABS(LH-RH)>1 => return false;)
//else, do nothing, depth of the right and left node is the only thing to calculate