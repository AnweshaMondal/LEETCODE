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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String str ="";
        if(root == null) return list;
        return dfs(root, list,str);
    }

    List<String> dfs(TreeNode root, List<String> list,String str){

        if(root == null) return list; 

        str+=root.val+"->";
        if(root.left == null && root.right == null)
        {
            list.add(str.substring(0,str.length()-2));
        }
        //if not a leaf node , then call next iteration
        dfs(root.left,list,str);
        dfs(root.right,list,str);

        return list;
    }
}