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
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        //BASE CASE
        // If the starting pixel already has the target color, return the image
        if (image[sr][sc] == color) {
            return image;
        }

        int initcolor = image[sr][sc]; // Original color of the starting pixel
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Possible directions

        // Perform DFS to flood fill the image
        dfsOnMatrix(image, directions, initcolor, color, sr, sc);

        return image;
    }

    // Function for DFS Traversal
    static void dfsOnMatrix(int[][] image,
                            int[][] dir,
                            int initcolor,
                            int newColor,
                            int row, int col) {
        int rowMax = image.length;
        int colMax = image[0].length;

        // Fill the current pixel with the new color
        image[row][col] = newColor;

        // Generate valid positions
        for (int[] arr : dir) {
            int newR = row + arr[0];
            int newC = col + arr[1];

            // Check if the new position is within bounds
            if (newR >= 0 && newR < rowMax && newC >= 0 && newC < colMax) {
                // Check if the pixel has the original color and hasn't been processed
                if (image[newR][newC] == initcolor) {
                    dfsOnMatrix(image, dir, initcolor, newColor, newR, newC);
                }
            }
        }
    }
}