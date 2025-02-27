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

 //Naive aproach -> store in a list, create right skwewd tree
class Solution {
    public TreeNode increasingBST(TreeNode root) {

        List<Integer> list = new  ArrayList<Integer>();     
        dfs(root,list);//returns inorder traversal list

        TreeNode newroot = new TreeNode(list.get(0));
        TreeNode ptr = newroot;
        for(int i = 1; i<list.size(); i++)
        {
            ptr.right = new TreeNode(list.get(i));
            ptr = ptr.right;
        }
        return newroot;
    }

    List<Integer> dfs(TreeNode root, List<Integer> list){
           
           if(root == null)
           {
            return list;
           }

           if(root.left == null && root.right == null)
           {
             list.add(root.val);
             return list;
           }

           //first left, then root, then right 
           dfs(root.left,list);//returns modified list carrying left child
           list.add(root.val);
           dfs(root.right,list);//returns modified list carrying right child

        return list;
    }
}