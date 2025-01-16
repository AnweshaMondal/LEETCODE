/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left = null;
 *     TreeNode right = null;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Codec {
    // Serialize the tree into a string
    public String serialize(TreeNode root) {
        if (root == null) return "[]";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                sb.append("null,");
            } else {
                sb.append(curr.val);
                sb.append(",");
                queue.add(curr.left);//add null children intentionally
                queue.add(curr.right);//\U0001f642we can add null in b/w values in a queue
            }
        }

        // Remove trailing comma and return
        sb.setLength(sb.length() - 1);
        return "[" + sb.toString() + "]";
    }

    // Deserialize the string back into a tree-> constructing a BT from a string
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;

        String[] nodes = data.substring(1, data.length() - 1).split(","); //data.substring(1, data.length() - 1): 
                                                                        //Removes the enclosing square brackets ([ ]) from the serialized string to isolate the node values. For example:
         //.split(",")                                                  //Input: "[1,2,3,null,null,4,5]"
         //Input: "1,2,3,null,null,4,5"                              //Result: "1,2,3,null,null,4,5"
         //Result: ["1", "2", "3", "null", "null", "4", "5"] ->Array of Strings

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));//String to Integer
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();

            // Process left child
            if (!nodes[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.left);
            }
            i++;

            // Process right child
            if (i < nodes.length && !nodes[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));