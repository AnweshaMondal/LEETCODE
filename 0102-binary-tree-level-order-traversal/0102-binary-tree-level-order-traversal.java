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
//     public List<List<Integer>> levelOrder(TreeNode root) {
      
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
       
//         List<List<Integer>> lst = new LinkedList<List<Integer>>(); 
//          if(root == null){
//             return lst;
//            }


//         while(!q.isEmpty()){
      
//            int level_num = q.size();
//            List<Integer> sublist = new LinkedList<>();

//            for(int i = 0; i<level_num; i++){
//                  TreeNode curr =  q.poll();
//             if(curr.left != null){
//             q.add(curr.left);
//             }
//              if(curr.right != null){
//             q.add(curr.right);
//             }
//             sublist.add(curr.val);
//            }
//           lst.add(sublist);
//         }
//     return lst;
//     }
          
// }


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) 
    {  
        Queue<TreeNode> q = new LinkedList<>();//queue for bfs
        List<List<Integer>> sol = new ArrayList<>();//solution list

        if(root == null)
        {
            return sol;
        }
      
        q.add(root);

        while(! q.isEmpty())
        {
            int size = q.size();//no of nodes in a level
            List<Integer> sublist = new ArrayList<>();

            for(int i = 0; i<size ;i++)
            {
               TreeNode curr = q.poll();
               sublist.add(curr.val);

               //add left child
               if(curr.left != null)
               {
                q.add(curr.left);
               }

               //add right child
               if(curr.right != null)
               {
                q.add(curr.right);
               }  
            }
            sol.add(sublist);
        }
        
      return sol;
    }
}