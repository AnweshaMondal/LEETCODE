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

 //We perform an in-order traversal (left → root → right)->Sortd Array
// The prev variable keeps track of the previous node value.
class Solution {
    public int getMinimumDifference(TreeNode root) {
         
        List<Integer> list = new ArrayList<Integer>();
        list = inOrder(root,list);
        int size = list.size();
        int mindiff = Integer.MAX_VALUE;

        for(int i = 0; i<size-1; i++)
        {
            int diff = Math.abs(list.get(i+1)-list.get(i));
            mindiff = Math.min(diff,mindiff);
        }

        return mindiff;
    }

    List<Integer> inOrder(TreeNode root,List<Integer>list){
           
           if(root == null)
           {
            return list;
           }
          
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);

        return list;
    }
}