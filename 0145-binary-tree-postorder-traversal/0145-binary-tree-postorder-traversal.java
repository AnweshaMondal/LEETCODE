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
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         TreeNode curr = root;
//         return postOrder(list,curr);
//     }
//      //left -> right -> root
//     static List<Integer> postOrder(List<Integer> list, TreeNode curr){
//                 if(curr == null){
//                     return list;
//                 }
//                 postOrder(list,curr.left);
//                 postOrder(list,curr.right);
//                 list.add(curr.val);
//                 return list;
//     }
// }


//USING 2 STACKS
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
       //Create 2 stacks and a list to store values
//        Stack<TreeNode> st1 = new Stack<>();
//        Stack<TreeNode> st2 = new Stack<>();
//        List<Integer> list =  new ArrayList<>();

//        if(root ==  null){
//         return list;
//        }else{
//         st1.push(root);
//        }

//        while (!st1.isEmpty()){
//            TreeNode curr = st1.pop();
//            st2.add(curr);

//            //add poped element's left and right child
//             if(curr.left != null){
//                 st1.push(curr.left);
//             }
//              if(curr.right != null){
//                 st1.push(curr.right);
//             }
//        }
//      //Pop stack2's elements
//      while(!st2.isEmpty()){
//         list.add(st2.pop().val);
//      }

//         return list;
//     }
// }

//USING 1 STACK
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //declare 1 stack and a list
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
          if(root == null){
            return list;
          }else{
          TreeNode curr = root;
          while(curr!=null || !st.isEmpty()){
               
               while(curr != null)
               {
                st.push(curr);
                curr = curr.left;
               } 
               //ie left child is null
                 TreeNode temp =(st.peek()).right;
                 //if RC exists
                 if(temp != null){
                   curr = temp;
                 }
                 else{
                    //right child is also null
                    temp = st.pop();
                    list.add(temp.val);
                    
                    while(!st.isEmpty() && st.peek().right == temp)
                    {
                        temp = st.pop();
                        list.add(temp.val);
                    }
                 }
             
          }

    }
    return list;
   }
}