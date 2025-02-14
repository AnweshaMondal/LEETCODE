// //Removing any part or any given pattern from String == Use Stack
// //Find the first ocurrence of part -> remove -> repeat untill all part is removed

// class Solution {
//     public String removeOccurrences(String s, String part) {
        
//         Stack<Character> st = new Stack<>();
//         int partlen = part.length();
//         char init = part.charAt(0);
      
//       for(int i= 0; i<s.length(); i++)
//       {
//         st.push(s.charAt(i));
//         //  If stack size is greater than or equal to the part length, check for match
//         if(st.size()>= partlen)
//         {
            
//         }
//       }

      
//     }
// }

//String Builder
class Solution {
    public String removeOccurrences(String s, String part) {

        //String->String Builder conversion
        StringBuilder sb = new StringBuilder(s);
        
        while(sb.indexOf(part)!= -1)
        {
            int index = sb.indexOf(part);
            sb.delete(index, index+part.length());
        }

        return sb.toString();
    }
}