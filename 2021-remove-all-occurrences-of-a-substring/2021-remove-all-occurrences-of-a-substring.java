// //Removing any part or any given pattern from String == Use Stack
// //Find the first ocurrence of part -> remove -> repeat untill all part is removed

import java.util.Stack;

class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int partlen = part.length();

        for (int i = 0; i < s.length(); i++) {  
            st.push(s.charAt(i));

            // Check if the stack contains the part at the top
            if (st.size() >= partlen && containsPart(part, partlen, st)) {
                for (int j = 0; j < partlen; j++) {
                    st.pop(); // Remove the part from the stack
                }
            }
        }

        // Correct way to build the final string
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        res.reverse(); // Reverse since stack stores elements in LIFO order

        return res.toString();
    }  

    boolean containsPart(String part, int partlen, Stack<Character> st) {  
        Stack<Character> temp = new Stack<>();
        temp.addAll(st); // Copy contents of st into temp  

        for (int i = partlen - 1; i >= 0; i--) {
            // Ensure stack is not empty before calling peek()
            if ( temp.peek() != part.charAt(i)) {
                return false;
            }
            temp.pop();              
        }
        return true;
    }
}

//String Builder
// class Solution {
//     public String removeOccurrences(String s, String part) {

//         //String->String Builder conversion
//         StringBuilder sb = new StringBuilder(s);
        
//         while(sb.indexOf(part)!= -1)
//         {
//             int index = sb.indexOf(part);
//             sb.delete(index, index+part.length());
//         }

//         return sb.toString();
//     }
// }

//By String In built Function
// class Solution {
//     public String removeOccurrences(String s, String part) {

//         while(s.contains(part))//contains() is also a function of HashSet
//         {
//           int partIndex = s.indexOf(part);
//           s = s.substring(0, partIndex)+s.substring(partIndex+part.length());
//         }

//         return s;
//     }
// }

