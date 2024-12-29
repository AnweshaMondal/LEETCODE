// class Solution {
//     public int strStr(String haystack, String needle) {

//         int m = haystack.length(); 
//         int n = needle.length();
      
//     for(int i = 0; i<=m-n ; i++){
//         //Start from index 0 and slide the window by one position until the 
//         //remaining substring in haystack is shorter than needle.
//         if(haystack.substring(i, i+n).equals(needle)){ //ryt index exclusive
//             return i;
//         }   
//     }
        
//         return -1;
//     }
// }

public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle); // Returns the first occurrence or -1
    }
}
