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
    public TreeNode sortedArrayToBST(int[] nums) {
          int l = 0;
          int r = nums.length - 1;

           return helper(nums,l ,r );
    }
     
    TreeNode helper(int arr[], int l, int r ){

        //base condition
        if(l>r){
            return null; 
        }
        
          int mid = (l+r)/2;
          TreeNode root = new  TreeNode(arr[mid]);
          root.left = helper(arr,l, mid-1);
          root.right = helper(arr,mid+1, r);

           return root;
    }
}