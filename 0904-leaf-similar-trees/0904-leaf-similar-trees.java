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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
     
         
        list1 = StoreLeaf(root1,list1);
        list2 = StoreLeaf(root2,list2);

        if(list1.size() != list2.size()) return false;
        //In Java, list2.get(i) != list1.get(i) compares object references
        // instead of actual values.
// Since list1 and list2 contain Integer objects (not int),
// != checks if they are the same object in memory, not if their values are equal.

        for(int i = 0; i<list2.size(); i++)
        {
            if(!list2.equals(list1)) return false;
        }

    return true;
    }


    List<Integer> StoreLeaf(TreeNode root, List<Integer>list){

        if(root == null) return list;//its a non-leaf node, with 1 child only

        //if it is a leaf node
        if(root.left == null && root.right == null)
        {
           list.add(root.val);
           return list;
        }
       
       StoreLeaf(root.left,list);//returns modified list
       StoreLeaf(root.right,list);//returns modified list

    return list;

    }
}