// class Solution {
//     public String shiftingLetters(String s, int[][] shifts) {
//         char[] arr = s.toCharArray();
        
//         for(int i = 0; i<shifts.length ;i++)
//         {
//           int[] row = shifts[i];
//           int start  = row[0];
//           int end = row[1];
//           int direction = row[2];

//             for(int j = start; j<= end ; j++)
//             {
//                 //direction judgement
//                 if(direction ==1)
//                 {
//                   if(arr[j] == 'z')
//                   {
//                     arr[j] = 'a';
//                   }
//                   else
//                   {
//                      arr[j]++;
//                   }
                  
//                 }
//                 else if(direction == 0)
//                 {
//                     if(arr[j] == 'a')
//                   {
//                     arr[j] = 'z';
//                   }
//                   else
//                   {
//                   arr[j]--;
//                   }

//                 }
//             }
//         }
//       String res = "";
//             for(int i = 0; i <arr.length; i++)
//             {
//                res+= arr[i];
//             }

//         return res;

//     }
// }//TLE

//Optimum ->Prefix Sum
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1]; // Difference array

        // Step 1: Process shift operations
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) {  // Forward shift
                diff[start] += 1;
                diff[end + 1] -= 1;
            } else {  // Backward shift
                diff[start] -= 1;
                diff[end + 1] += 1;
            }
        }

        // Step 2: Compute prefix sum
        int shiftValue = 0;
        char[] result = s.toCharArray();

        for (int i = 0; i < n; i++) {
            shiftValue += diff[i]; // Apply cumulative shift
            int newChar = (result[i] - 'a' + shiftValue) % 26; // Wrap around alphabet
            if (newChar < 0) newChar += 26; // Handle negative shifts

            result[i] = (char) ('a' + newChar);
        }

        return new String(result);
    }
}

