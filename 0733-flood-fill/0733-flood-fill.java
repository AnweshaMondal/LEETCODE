// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {

//         int copy[][] = image;//copy of the given matrix to manipulate on
//         int directions[][] ={{-1,0},
//                              {+1,0},
//                              {0,-1},
//                              {0,+1} };
//         int initcolor = image[sr][sc];
//         dfsOnMatrix(copy,image,directions,initcolor, color,sr,sc);
//         return copy;
//     }

// //Function for DFS Traversal
//    static  void dfsOnMatrix(int[][]copy,
//                      int[][]image, 
//                      int[][]dir, 
//                      int initcolor,
//                      int newColor,
//                      int row, int col)
//     {
//        int rowMax = image.length;
//        int colMax = image[0].length;
        
//         //fill the startng position with the new Color
//         copy[row][col] = newColor;

//        //generate valid positions
//        for(int arr[]:dir)
//        {
//           int newR = row+arr[0];
//           int newC = col+arr[1];

//          if(newR>=0 && newR<rowMax && newC>=0 && newC<colMax)
//          {
//             if(image[newR][newC] == initcolor && copy[newR][newC] != newColor)
//             {
//                 //copy[newR][newC] != newColor)->base condition , working as visited array
//                 dfsOnMatrix(copy,image,dir,initcolor,newColor,newR, newC);
//             }
//          }
//        }
//     }
// }
//optimized
//DFS
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
//         //BASE CASE
//         // If the starting pixel already has the target color, return the image
//         if (image[sr][sc] == color) {
//             return image;
//         }

//         int initcolor = image[sr][sc]; // Original color of the starting pixel
//         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Possible directions

//         // Perform DFS to flood fill the image
//         dfsOnMatrix(image, directions, initcolor, color, sr, sc);

//         return image;
//     }

//     // Function for DFS Traversal
//     static void dfsOnMatrix(int[][] image,
//                             int[][] dir,
//                             int initcolor,
//                             int newColor,
//                             int row, int col) {
//         int rowMax = image.length;
//         int colMax = image[0].length;

//         // Fill the current pixel with the new color
//         image[row][col] = newColor;

//         // Generate valid positions
//         for (int[] arr : dir) {
//             int newR = row + arr[0];
//             int newC = col + arr[1];

//             // Check if the new position is within bounds
//             if (newR >= 0 && newR < rowMax && newC >= 0 && newC < colMax) {
//                 // Check if the pixel has the original color and hasn't been processed
//                 if (image[newR][newC] == initcolor) {
//                     dfsOnMatrix(image, dir, initcolor, newColor, newR, newC);
//                 }
//             }
//         }
//     }
// }

// //BFS
// import java.util.LinkedList;
// import java.util.Queue;

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         // If the starting pixel already has the target color, return the image
//         if (image[sr][sc] == color) {
//             return image;
//         }

//         int initColor = image[sr][sc]; // Original color of the starting pixel
//         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Possible directions

//         // Perform BFS
//         return bfs(image, sr, sc, color, initColor, directions);
//     }

//     int[][] bfs(int[][] image, int sr, int sc, int color, int initColor, int[][] dir) {
//         int m = image.length;
//         int n = image[0].length;

//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[]{sr, sc}); // Add the starting pixel to the queue
//         // image[sr][sc] = color; // Mark the starting pixel as visited

//         while (!q.isEmpty()) {

//             int[] current = q.poll();//parent cell of this iteration
//             int row = current[0];
//             int col = current[1];
            
// // image[row][col] = color; // wrong placement
// //When a neighbor is added to the queue, its color is immediately updated 
// // to color. This ensures that the same pixel is not added to the queue multiple
// //  times.
//             // Explore all four directions
//             for (int[] it : dir) {
//                 int newRow = row + it[0];
//                 int newCol = col + it[1];

//                 // Check if the new position is within bounds and has the original color
//                 if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
//                         && image[newRow][newCol] == initColor) {
//                     q.add(new int[]{newRow, newCol}); // Add the pixel to the queue
//                     image[row][col] = color; // Mark the pixel as visited
//                 }
//             }
//         }

//         return image;
//     }
// }

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // If the starting pixel already has the target color, return the image
        if (image[sr][sc] == color) 
        {
            return image;
        }

        int initColor = image[sr][sc]; // Original color of the starting pixel
        int[][] directions = {{-1, 0},
                               {1, 0}, 
                               {0, -1}, 
                               {0, 1}}; // Possible directions

        // Perform BFS
        return bfs(image, sr, sc, color, initColor, directions);
    }

    int[][] bfs(int[][] image, int sr, int sc, int color, int initColor, int[][] dir) {
       
        int m = image.length;
        int n = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc}); // Add the starting pixel to the queue
        image[sr][sc] = color; // Mark the starting pixel as visited

        while (!q.isEmpty()) {
            int[] current = q.poll(); // Parent cell of this iteration
            int row = current[0];
            int col = current[1];

            // Explore all four directions
            for (int[] it : dir) {
                int newRow = row + it[0];
                int newCol = col + it[1];

                // Check if the new position is within bounds and has the original color
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                        && image[newRow][newCol] == initColor) {
                    q.add(new int[]{newRow, newCol}); // Add the pixel to the queue
                    image[newRow][newCol] = color; // Mark the pixel as visited
                }
            }
        }

        return image;
    }
}