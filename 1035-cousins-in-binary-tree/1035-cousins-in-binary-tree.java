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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null)
        {
            return false;
        }

        q.add(root);

        while(!q.isEmpty())//outer loop
        {
           int size = q.size();
           boolean findX = false;
           boolean findY = false;

           for(int i = 0; i<size; i++) //inner loop to process ecah node at a given level
           {

            TreeNode curr = q.poll();

            //check if x and y are siblings
              if(curr.left != null && curr.right != null)
              {
                 if((curr.left.val == x && curr.right.val == y) ||
                   (curr.left.val == y && curr.right.val == x))
                    {
                     return false;
                    }

               }      
            //if x, y are not siblings check if they are cousins
                if(curr.left != null)
                 {
                    if(curr.left.val == x) findX = true;
                    if(curr.left.val == y) findY = true;
                    q.add(curr.left);
                 }

                 if(curr.right != null)
                 {
                    if(curr.right.val == x) findX = true;
                    if(curr.right.val == y) findY = true;
                    q.add(curr.right);
                 }
            }
    
           
           //if both of them are present in the same level
           if(findX && findY ) return true;
           //if any of the them is missing
        //    if((findX == true && findY == false)||(findY == true && findX == false)||(findX == false && findY == false))
        //    {
            // return false;
        //    }
              if (findX || findY) return false;
        }

        return false;//it should not reach here
    }
}

// class Solution {
//     public boolean isCousins(TreeNode root, int x, int y) {
//         if (root == null) return false;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while (!q.isEmpty()) { // Process each level
//             int size = q.size();
//             boolean findX = false, findY = false;

//             for (int i = 0; i < size; i++) { // Process all nodes at this level
//                 TreeNode curr = q.poll();

//                 // Check if x and y are siblings
//                 if (curr.left != null && curr.right != null) {
//                     if ((curr.left.val == x && curr.right.val == y) ||
//                         (curr.left.val == y && curr.right.val == x)) {
//                         return false; // If they have the same parent, they are not cousins
//                     }
//                 }

//                 // Check if x or y is found at this level
//                 if (curr.left != null) {
//                     if (curr.left.val == x) findX = true;
//                     if (curr.left.val == y) findY = true;
//                     q.add(curr.left);
//                 }
//                 if (curr.right != null) {
//                     if (curr.right.val == x) findX = true;
//                     if (curr.right.val == y) findY = true;
//                     q.add(curr.right);
//                 }
//             }

//             // If both x and y are found at the same level, they are cousins
//             if (findX && findY) return true;

//             // If only one of them is found, they cannot be cousins
//             if (findX || findY) return false;
//         }

//         return false; // Default case (should never reach)
//     }
// }
