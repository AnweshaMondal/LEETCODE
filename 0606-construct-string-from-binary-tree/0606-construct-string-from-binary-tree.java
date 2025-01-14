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
    public String tree2str(TreeNode root) {

        //if there is no node
        if(root ==  null)
        {
            return ""; //return null String
        }
        
        //cretae a string of the root value
        StringBuilder result = new StringBuilder(String.valueOf(root.val));

      //If it is a aleaf node none of the 3 if conditions won't execute, just the String(root.val)
      //will be returned

        //left node null , right node exists
    if(root.left == null && root.right != null)
        {
            result.append("()");
            result.append("(");
            result.append(tree2str(root.right));
            result.append(")");
        }

    else{

        if(root.left != null){
            result.append("(");
            result.append(tree2str(root.left));
            result.append(")");
        }
        
        //defalut for right sub tree
        if(root.right != null)
        {
         result.append("(");
         result.append(tree2str(root.right));
         result.append(")");
        }
    }   

        return result.toString();
    }
}