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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        return helper(root, sol);
    }

    List<Integer> helper(TreeNode root, List<Integer> sol)
    {
        if(root ==  null)
        {
            return sol;
        }

        helper(root.left,sol);
        sol.add(root.val);
        helper(root.right,sol);
        return sol;
    }
}