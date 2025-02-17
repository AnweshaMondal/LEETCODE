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
//     public int maxDepth(TreeNode root) {
//          if(root == null){
//                 return 0;
//             }

//             else{
//         int lc = maxDepth(root.left);
//         int rc = maxDepth(root.right);
//         int maxHeight = 1+Math.max(lc,rc);
//          return maxHeight;
//         }   
       
//     }

// }

class Solution { //Authentic Way to compute height of a tree , both min , max, 
                 //covering all the cases
    public int maxDepth(TreeNode root) {
         
        if(root== null)
        {
           return 0;
        }
        if(root.left == null&& root.right==null)
        {
            return 1;
        }

        if(root.left != null && root.right == null)
        {
            return 1+maxDepth(root.left);
        }

        if(root.left == null && root.right != null)
        {
            return 1+maxDepth(root.right);
        }

        //If both the subTrees exist
        int lc = 1+maxDepth(root.left);
        int rc = 1+maxDepth(root.right);

        return Math.max(lc,rc);
    }
}
//by BFS-> USING EXTERNAL QUEUE
// class Solution {
//     public int maxDepth(TreeNode root) {

//         if(root == null)
//         {
//             return 0;
//         }

//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         int level = 0;

//         while(!q.isEmpty())
//         {
//             int size = q.size();
//             level ++;

//             for(int i = 0 ;i<size ;i++)
//             {
//                 TreeNode curr = q.poll();
//                 if(curr.left != null)
//                 {
//                     q.add(curr.left);
//                 }
//                 if(curr.right != null)
//                 {
//                     q.add(curr.right);
//                 }
//             }

//         }
//         return level;
//     }
// }