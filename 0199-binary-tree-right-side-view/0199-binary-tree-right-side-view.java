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
import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return sol;
        }

        q.add(root); // Start with the root node.

        while (!q.isEmpty()) {
            int size = q.size(); // Number of nodes at the current level.
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                // Add children to the queue for the next level.
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

                // Capture the last node (rightmost) of this level.
                if (i == size - 1) {
                    sol.add(curr.val);
                }
            }
        }

        return sol;
    }
}
