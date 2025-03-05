/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
//By DFS
class Solution {

    // int maxDepth = 0;

    public int maxDepth(Node root) {
        if(root== null) return 0;
        int max = 0;
        int size = root.children.size();
        Node child;
        for(int i = 0 ;i<size ; i++)
        {
            child = root.children.get(i);
            max = Math.max(max,maxDepth(child));
        }
        
        return max+1;
    }
}

// Corrected Code Using BFS (Iterative)
// class Solution {
//     public int maxDepth(Node root) {
//         if (root == null) return 0;

//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);
//         int depth = 0;

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 Node curr = queue.poll();
//                 for (Node child : curr.children) {
//                     queue.add(child);
//                 }
//             }
//             depth++;
//         }

//         return depth;
//     }
// }

