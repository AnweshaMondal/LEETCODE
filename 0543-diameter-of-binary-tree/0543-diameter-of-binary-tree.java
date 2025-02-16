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

 //Brute Force
class Solution {
    int maxlen = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0 ;
        }

        //for each node
         int lh = height(root.left);
         int rh = height(root.right);

         maxlen= Math.max(maxlen , lh+rh);

         //recussive call for child nodes
         int subTree = Math.max(diameterOfBinaryTree(root.left),
                                diameterOfBinaryTree(root.right));
         return Math.max(maxlen,subTree);
    }

    static int height(TreeNode node){ //Height = no of edges

    if(node == null){
        return 0; //see the definition of height , and return -1 or 0 according to it
     }

        int rc = 1+ height(node.right);
        int lc = 1+ height(node.left);

        return Math.max(lc,rc);
    }
}

