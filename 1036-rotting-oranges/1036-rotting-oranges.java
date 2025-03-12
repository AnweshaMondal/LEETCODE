//Class to store position of rotten oranges
// class Node{
//     int i;
//     int j;
//     public Node(int i, int j)
//     {
//         this.i = i;
//         this.j = j;
//     }
// }

//This is a multi-source BFS problem where rotting spreads level by level.
// We'll use a queue to store all initially rotten oranges and process them 
//in layers (minutes).
class Solution {
    public int orangesRotting(int[][] grid) {
        
     int m = grid.length;
     int n = grid[0].length;
    
     int dir[][]={{-1,0},
                    {1,0},
                    {0,-1},
                    {0,1}};
    Queue<int[]> q = new LinkedList<>();
    int fresh = 0;//no of fresh oranges
    int minutes = 0;
 
    //find rotten oranges' positions
    for(int i =0; i<m; i++)
    {
        for(int j = 0; j<n; j++)
        {
            if(grid[i][j] == 2)
            {
                q.add(new int[]{i,j});//data type = int[], value={i,j}
            }

            if(grid[i][j]==1)
            {
              fresh++;
            }
        }
    }

while(!q.isEmpty())
{
   int sources = q.size();//total no of initial rotten orange
   boolean rot = false;
   //1 level traversing
   for(int i =0; i<sources; i++)
   {
     int[]cell = q.poll();
     int row = cell[0];
     int col = cell[1];

     for(int it[]:dir)
     {
        int newrow = row+it[0];
        int newcol = col+it[1];
        if(newrow>=0 && newrow<m  &&
           newcol>=0 && newcol<n && grid[newrow][newcol]==1)
           {
             grid[newrow][newcol]= 2;
             q.add(new int[]{newrow, newcol});
             rot=true;//atleast 1 orange rots in a level
             fresh--;
           }
        }
    }
   
      if(rot) minutes++;
    }

    return (fresh==0)?minutes:-1;
  }

} 