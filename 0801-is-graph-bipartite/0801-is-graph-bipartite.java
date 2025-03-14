class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int v = graph.length;//graph[neighbour]==-1->stagged array
        int []colors = new int[v];
        // boolean result = true;

        for(int i = 0; i <v; i++)colors[i]=-1;

        for(int i = 0 ;i<v; i++)
        {
            if(colors[i]==-1)
            {
               boolean result = bfs(graph,colors,i,1);
               if(result == false)return false;//this if is crucial and mandetory
            }
        }

        return true;
    }

     boolean bfs(int[][]graph, int[]colors,  int start, int color)
     {
        colors[start] = color;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty())
        {
            int currnode = q.poll();
            for(int neighbour :graph[currnode])
            {
               if(colors[neighbour]==-1)//if the neighbour is uncolored , color it in opposite color
               {
                 colors[neighbour] = 1-colors[currnode];
                 q.offer(neighbour);//new method
                 //q.add(neighbour);
               }
               else if(colors[neighbour]== colors[currnode])//the graph is colored and has the same color as the current node
               {
                return false;
               } 
            }
        }
    return true;
    }
}