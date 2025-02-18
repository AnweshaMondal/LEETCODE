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
 //Solution by Level Order Traversal
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> avg = new ArrayList<Double>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null)
        {
            return avg;
        }

        q.add(root);

        while(!q.isEmpty())
        {
           int size = q.size();
           double sum = 0;
           for(int i=0; i<size; i++)
           {
             TreeNode curr = q.poll();
             sum+= (double)curr.val;

             //insert left and right child into the queue
             if(curr.left != null)
             {
                q.add(curr.left);
             }
             if(curr.right != null)
             {
                q.add(curr.right);
             }
           }
           avg.add((double)(sum/size));
        }
        
     return avg;
    }
}