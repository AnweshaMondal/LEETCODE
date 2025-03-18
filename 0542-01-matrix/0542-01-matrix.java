// import java.util.LinkedList;
// import java.util.Queue;

// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//         int[][] ans = new int[m][n];

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (mat[i][j] == 1) {
//                     // Perform BFS for each cell with value 1
//                     ans[i][j] = bfs(mat, dirs, i, j);
//                 } else {
//                     ans[i][j] = 0; // Cells with 0 have distance 0
//                 }
//             }
//         }

//         return ans;
//     }

//     private int bfs(int[][] mat, int[][] dirs, int row, int col) {
//         int m = mat.length;
//         int n = mat[0].length;
//         Queue<int[]> queue = new LinkedList<>();
//         boolean[][] visited = new boolean[m][n];

//         queue.offer(new int[]{row, col});
//         visited[row][col] = true;
//         int distance = 0;

//         while (!queue.isEmpty()) {

//             int size = queue.size();
//             for (int i = 0; i < size; i++) 
//             {
//                 int[] curr = queue.poll();
//                 int r = curr[0];
//                 int c = curr[1];

//                 // If we find a 0, return the current distance
//                 if (mat[r][c] == 0) {
//                     return distance;
//                 }

//                 // Explore neighbors
//                 for (int[] dir : dirs) {
//                     int newRow = r + dir[0];
//                     int newCol = c + dir[1];
// //add all neighbours w/o judging their values 0/1, will judge it when poped, in neighbour loop
// //mark them as visited and add to queue
//                     if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
//                         queue.offer(new int[]{newRow, newCol});
//                         visited[newRow][newCol] = true;
//                     }
//                 }
//             }
//             distance++; // Increment distance after processing each level
//         }

//         return distance; // This will never be reached as per the problem constraints
//     }
// }


//optimized
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all 0s and set their distance to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Perform BFS from each 0
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    if (dist[newRow][newCol] > dist[row][col] + 1) {
                        dist[newRow][newCol] = dist[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return dist;
    }
}