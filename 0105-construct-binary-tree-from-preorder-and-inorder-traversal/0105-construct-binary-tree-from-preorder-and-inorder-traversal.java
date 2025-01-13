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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //store the inorder key in a hashmap to retrieve in O(1) TC
        HashMap<Integer,Integer> inorderMap = new HashMap<>();
        
        int preStart = 0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;

        //Store the items of Hashmap
        for(int i = 0; i<inorder.length; i++)
        {
               inorderMap.put(inorder[i],i); //key,value
        }

        return buildTree(preorder, preStart, preEnd ,inorder , inStart, inEnd, inorderMap);
        
    }


    TreeNode buildTree(int[] preOrder, int preStart, int preEnd,
                       int[] inOrder, int inStart, int inEnd,
                       HashMap<Integer,Integer> inorder){

                        if(preStart>preEnd || inStart>inEnd){
                            return null;
                        }

           int rootval = preOrder[preStart];
           TreeNode root = new TreeNode(rootval); //create thr root node

           //No of nodes in left sub Tree
           int no_left_node = inorder.get(rootval)-inStart;

           //rootIndex
           int rootIndex = inorder.get(rootval);

           root.left = buildTree(preOrder, preStart + 1, preStart + no_left_node, 
                         inOrder, inStart, rootIndex - 1, inorder);

           root.right = buildTree(preOrder, preStart + no_left_node+1, preEnd ,
                         inOrder, rootIndex+1, inEnd , inorder);
                         
                         
        return root;
           
    }
}