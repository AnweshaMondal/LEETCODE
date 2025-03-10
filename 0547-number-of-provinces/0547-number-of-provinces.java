//no of connected components
class Solution {

    public int findCircleNum(int[][] isConnected) 
    {   
        int count = 0;
        int vis[] = new int[isConnected.length];
        ArrayList<ArrayList<Integer>> adj = matrixToAdj(isConnected);
        // isConnected.length =no of vertices
        for(int i = 0 ; i<isConnected.length; i++)
        {
           if(vis[i] == 0)
           {
             dfs(adj,vis,i);
             count++;
           }
        }
        return count;
    }

    //DFS Function
    void dfs(ArrayList<ArrayList<Integer>>adj , int vis[], int node)
    {
        // if(vis[node] == 1) return;

        vis[node] = 1;
        for(int i = 0; i<adj.get(node).size(); i++)
        {   
            int ele = adj.get(node).get(i);
            if(vis[ele] == 0)
            {
            dfs(adj,vis,ele);
            }
        }
    }
    
   //Function to change matrix to adj list
    ArrayList<ArrayList<Integer>> matrixToAdj(int[][] isConnected)
    {    
        //CREATE AN ADJACENCY LIST
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ;i<isConnected.length; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
          
        for(int i = 0 ; i<isConnected.length ;i++)
        {
            for(int j =0; j<isConnected[0].length ; j++)
            {
                  if(i!=j && isConnected[i][j]==1 )
                  {
                    adj.get(i).add(j);
                  }
            }
        }
        return adj;
    }
}