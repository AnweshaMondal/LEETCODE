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
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         TreeNode curr = root;
//         return inOrder(list,curr);
//     }

//    HELPER FUNCTION
//    //left->root->right
//     static List<Integer> inOrder(List<Integer> list, TreeNode ptr){
             
//              if(ptr == null){
//                 return list;
//              }

//          inOrder(list,ptr.left);
//          list.add(ptr.val);
//          inOrder(list,ptr.right);
//          return list;

//     } 

// }

//Iterative Solution


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Process the node-> BACKTRACT TO THE ROOT NODE :)
            curr = stack.pop();
            result.add(curr.val);
            
            // Move to the right subtree
            curr = curr.right;
        }
        
        return result;
    }
}
