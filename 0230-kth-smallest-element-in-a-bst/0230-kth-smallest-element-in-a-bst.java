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
 //InOrder Traversal of BST is a sorted array
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        int n = 0;
        TreeNode curr = root;

      
       while(curr != null || !st.isEmpty()){

        while(curr != null){
            st.push(curr);
            curr = curr.left;
        }

         curr = st.pop();
         n++;
         if(n==k){
            return curr.val;
         }

         curr = curr.right;
    }
         
     return Integer.MAX_VALUE;
    }
}