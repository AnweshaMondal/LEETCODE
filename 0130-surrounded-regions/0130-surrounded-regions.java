class Solution {
    public void solve(char[][] board) {

        int m = board.length; //no of rows
        int n = board[0].length;//no of cols
        boolean vis[][]= new boolean [m][n];//visited array
        int[][] dir = {{-1,0},
                       {1,0},
                       {0,-1},
                       {0,1}};

        //Traverse the 1st and last row
        for(int j = 0; j<n; j++)
        {
           if(board[0][j]=='O'&& vis[0][j]==false)
           {
             dfs(board,dir,0,j,vis);
           }
           
           if(board[m-1][j]=='O'&& vis[m-1][j]==false)
           {
             dfs(board,dir,m-1,j,vis);
           }
        }

        
        //Traverse the 1st and last column
        for(int j = 0; j<m; j++)
        {
           if(board[j][0]=='O'&& vis[j][0]==false)
           {
             dfs(board,dir,j,0,vis);
           }
           
           if(board[j][n-1]=='O'&& vis[j][n-1]==false)
           {
             dfs(board,dir,j,n-1,vis);
           }
        }

        //if all boundary 'O' have been traversed
        for(int i =1; i<m-1; i++)
        {
            for(int j = 1; j<n-1; j++)
            {
                if(board[i][j]=='O'&& vis[i][j]==false)
                {
                    board[i][j]='X';
                    vis[i][j]=true;
                    
                }
            }
        }
    }

    void dfs(char[][] grid,int dir[][], int sr, int sc, boolean vis[][])
    {
        vis[sr][sc] = true;
        int m = grid.length;
        int n = grid[0].length;

        for(int[] it:dir)
        {
            int newrow = sr+it[0];
            int newcol = sc+it[1];
        
            if(newrow>=0 && newrow<m && newcol>=0 &&newcol<n &&
               vis[newrow][newcol]==false && grid[newrow][newcol]=='O')
               {
                 dfs(grid,dir,newrow,newcol,vis);
               }
        }
    }
}