/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string
    public String serialize(TreeNode root) {
        
        if(root == null)
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr == null)
            {
                sb.append("null,");
            }
            else{
                sb.append(curr.val);
                sb.append(",");
                q.add(curr.left);//even if child is null add them, ie null can be addend in Queue in b/w
                q.add(curr.right);//nodes
            }
        }
        //remove the trailing ","
        sb.setLength(sb.length() - 1);//end index is excluded //.setLength() is a void type function
        sb.append("]");
        return sb.toString();
    }


    // Decodes your encoded data to tree->string to tree
    public TreeNode deserialize(String data) {
        
        if(data.equals("[]"))//.equals() cannot compare with null String
        {
            return null;
        }
        //if the string is not empty
        Queue<TreeNode> q = new LinkedList<>();
        data = data.substring(1, data.length()-1);   //last index excluded     
                                                    //omit "[]"
        String nodes[] = data.split(",");//creates an array of Strings 

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));//create the root node
        q.add(root);//initialization
        int i= 1;

        while(!q.isEmpty() && i<data.length())
        {
            TreeNode curr = q.poll();

            //process left child
            if(!nodes[i].equals("null"))
            {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.left);
            }//else keep left child null
            i++;

            //process right child
            if(!nodes[i].equals("null"))
            {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.add(curr.right);
            }//else keep right child null
            i++;

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));