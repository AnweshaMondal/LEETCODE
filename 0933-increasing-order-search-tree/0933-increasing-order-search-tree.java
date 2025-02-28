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
// class Solution {
//     public TreeNode increasingBST(TreeNode root) {

//         List<Integer> list = new  ArrayList<Integer>();     
//         dfs(root,list);//returns inorder traversal list

//         TreeNode newroot = new TreeNode(list.get(0));
//         TreeNode ptr = newroot;
//         for(int i = 1; i<list.size(); i++)
//         {
//             ptr.right = new TreeNode(list.get(i));
//             ptr = ptr.right;
//         }
//         return newroot;
//     }

//     List<Integer> dfs(TreeNode root, List<Integer> list){
           
//            if(root == null)
//            {
//             return list;
//            }

//            if(root.left == null && root.right == null)
//            {
//              list.add(root.val);
//              return list;
//            }

//            //first left, then root, then right 
//            dfs(root.left,list);//returns modified list carrying left child
//            list.add(root.val);
//            dfs(root.right,list);//returns modified list carrying right child

//         return list;
//     }
// }

//by recusion'
//We have to move backward ie childrens left = parent, how would I do that??
class Solution {
    
    TreeNode dummy = new TreeNode(-1);

    public TreeNode increasingBST(TreeNode root) {

    TreeNode res = dummy;//store dummy node's ptr int res cos dummy will move
    dfs(root);
    return res.right;
    }


    void dfs(TreeNode root)
    {
        if(root == null) return ;

        dfs(root.left);
        // curr == dummy; //curr points to dummy node
        dummy.right = root ;// add the current node of this call as dummy.right
        root.left = null;
       
        dummy = dummy.right;//update curr pointer to the tail node
        dfs(root.right);
    }
}