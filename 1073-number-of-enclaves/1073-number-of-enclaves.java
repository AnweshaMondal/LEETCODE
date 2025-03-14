//same as surrounding region
//traverse the boundary land cell,DO DFS/BFS, marks them as visited
//then traverse, middle elements

class Solution {
    public int numEnclaves(int[][] grid) {

      int m = grid.length;//no of rows
      int n = grid[0].length;//no of cols
      boolean vis[][] = new boolean[m][n];
      int count = 0;
      int [][] dir = {{-1,0},
                      {1,0},
                      {0,-1},
                      {0,1}};

      //Traverse first and last rows
      for(int i = 0; i<n; i++)
       {
         //first row
         if(grid[0][i]==1 && vis[0][i]==false)
         {
            vis[0][i] = true;
            bfs(grid,0, i, vis, dir);
         } 
         //last row
         if(grid[m-1][i]==1 && vis[m-1][i]==false)
          {
            vis[0][i] = true;
            bfs(grid,m-1, i, vis, dir);
          } 
        }

       //Traverse first and last cols
      for(int i = 0; i<m; i++)
      {
        //first col
        if(grid[i][0]==1 && vis[i][0]==false)
        {
          vis[i][0] = true;
          bfs(grid,i, 0, vis, dir);
        } 
        //last col
        if(grid[i][n-1]==1 && vis[i][n-1]==false)
        {
           vis[i][n-1] = true;
           bfs(grid,i, n-1, vis, dir);
        } 
    }

        //traverse the inner matrix
        for(int i = 1; i<m-1; i++)
        {
            for(int j = 1; j<n-1; j++)
            {
                if(grid[i][j]==1 && vis[i][j]==false)
                {  
                    vis[i][j] = true;
                    count++;
                }
            }
        }

        return count;
      }
       
    
    

    void bfs(int[][]grid, int sr, int sc, boolean[][]vis, int[][]dir)
    {
        vis[sr][sc] = true;//make the source aas visited 
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
       
        while(!q.isEmpty()){

            int cell[] = q.poll();
            int row = cell[0];
            int col = cell[1];

           for(int[] it: dir)
           {  
            int newrow = row + it[0];
            int newcol = col + it[1];

            if(newrow>=0 && newrow<grid.length && newcol>=0 && newcol<grid[0].length &&
               grid[newrow][newcol]==1 && vis[newrow][newcol]==false)
               {
                 vis[newrow][newcol]= true;
                 q.add(new int[]{newrow, newcol});
               }
            }
        }     
    }
}