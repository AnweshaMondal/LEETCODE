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

//by BFS-> USING EXTERNAL QUEUE
class Solution {
    public int maxDepth(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            level ++;

            for(int i = 0 ;i<size ;i++)
            {
                TreeNode curr = q.poll();
                if(curr.left != null)
                {
                    q.add(curr.left);
                }
                if(curr.right != null)
                {
                    q.add(curr.right);
                }
            }

        }
        return level;
    }
}