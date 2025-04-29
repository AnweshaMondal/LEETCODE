// class Solution {
//     public int strStr(String haystack, String needle) {

//         int m = haystack.length(); 
//         int n = needle.length();
      
//     for(int i = 0; i<=m-n ; i++){
//         //Start from index 0 and slide the window by one position until the 
//         //remaining substring right side in haystack is shorter than needle.
//         if(haystack.substring(i, i+n).equals(needle)){ //ryt index exclusive
//             return i;
//         }   
//     }
        
//         return -1;
//     }
// }

// public class Solution {
//     public int strStr(String haystack, String needle) {
//         return haystack.indexOf(needle); // Returns the first occurrence or -1
//     }
// }


class Solution {
    public int strStr(String haystack, String needle) {
     
      int m = haystack.length();
      int n = needle.length();

      for(int i= 0; i<=m-n; i++)
      {
        if(haystack.charAt(i) == needle.charAt(0))
        {
            if(isSameString(i,haystack,needle)) return i;
        }
      }
     return -1;
    }

boolean isSameString(int indx, String haystack, String needle)
{
   int i = indx;
   for(int j = 0; j<needle.length(); j++)
   {
     if(haystack.charAt(i)!= needle.charAt(j))
     {
        return false;
     }

      i++;
      
   }
   return true;
}
}

