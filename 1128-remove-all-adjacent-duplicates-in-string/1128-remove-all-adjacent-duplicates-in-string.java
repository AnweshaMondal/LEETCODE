//Some of the hidden test cases are likely very large in size (s.length ≈ 10^5), 
//and your String res = "" + repeated += concatenation is very inefficient in Java. 
//Strings are immutable, so res += char creates a new object each time.
// class Solution {
//     public String removeDuplicates(String s) {
        
//         String temp = "" ;
//         String res = s;

//         while(temp.length() != res.length())
//         {
//             temp = res; 
//             res = remove(res);
//         }
     
//      return res;
//     }

//     static String remove(String s)
//     {
//         int n = s.length();
//         int i = 0;
//         String res = "";
//         while(i<n)
//         {
//             if(i<n-1 && s.charAt(i) == s.charAt(i+1))
//             {
//               while(i<n-1 && s.charAt(i) == s.charAt(i+1))
//               {
//                 // ++i;//pre increment
//                 i+=2;//by doing this more test cases passed
//               }
//             }
              
//             else
//             {
//                 res+=s.charAt(i);
//                 i++;
//             }

            
//         }

//         return res;
//     }
// }

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == ch) {
                sb.deleteCharAt(len - 1); // Remove the duplicate
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
