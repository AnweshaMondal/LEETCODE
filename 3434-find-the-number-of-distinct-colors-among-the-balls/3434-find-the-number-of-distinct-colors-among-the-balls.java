import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n]; // Store results after each query
        
        HashMap<Integer, Integer> ballToColor = new HashMap<>(); // Track ball colors
        HashMap<Integer, Integer> colorToBall = new HashMap<>(); // Track distinct colors and no
                                                                 // of balls
                                                                 //in that color
        for (int i = 0; i < n; i++) 
        {
            int ball = queries[i][0];
            int color = queries[i][1];//color = new color

            //the ball in the query is old
            if (ballToColor.containsKey(ball))
            {
                   int oldcolor = ballToColor.get(ball);

                   if(colorToBall.containsKey(oldcolor))
                   {
                       int count = colorToBall.get(oldcolor);

                       if(count==1)
                       {  
                        // Remove if it's not assigned to any other ball
                         colorToBall.remove(oldcolor);
                       }
                       else
                       {
                          colorToBall.put(oldcolor,count-1);
                       }
                   }

                   ballToColor.remove(ball);
                // if (!ballToColor.containsValue(oldColor)) { //O(n) operation,n^2 worst t complexity  
            }
             ballToColor.put(ball,color);
              if(colorToBall.containsKey(color))
              {
                 int count = colorToBall.get(color);
                  colorToBall.put(color,count+1);
              }
              else
              {
                 colorToBall.put(color,1);
              }
              
            // Store the count of distinct colors after this query
            result[i] = colorToBall.size();
           
        }
            
        

        return result;
    }
}
