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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to store the index of each value in inorder array
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        // Start building the tree
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, 
                                     int[] inorder, int inStart, int inEnd, 
                                     Map<Integer, Integer> inorderIndexMap) {
        // Base case: if no elements are left to process
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root in the inorder array
        int rootIndex = inorderIndexMap.get(rootValue);

        // Number of elements in the left subtree
        int leftSize = rootIndex - inStart;

        // Recursively construct the left subtree
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, 
                                    inorder, inStart, rootIndex - 1, inorderIndexMap);

        // Recursively construct the right subtree
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, 
                                     inorder, rootIndex + 1, inEnd, inorderIndexMap);

        return root;
    }
}
