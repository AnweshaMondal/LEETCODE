// class Solution {
//     public boolean isValid(String s) {
        
//         Stack<Character> st = new Stack<>();
//         int n = s.length();

//         for(int i = 0; i<n; i++)
//         {
//             char ch = s.charAt(i);

//             //check if an  opening bracket
//             if(ch =='(' || ch == '{' || ch == '[')
//             {
//                 st.push(ch);
//             }

//             //if it is a closing bracket
//             else if(!st.isEmpty() && (ch == '}' || ch == ')'||ch == ']'))
//             {
//                 if(st.peek() == '(' && ch == ')')
//                 {
//                     st.pop();
//                 }

//                 else if(!st.isEmpty() && st.peek() == '{' && ch == '}')
//                 {
//                     st.pop();
//                 }

//                 else if(!st.isEmpty() && st.peek() == '[' && ch == ']')
//                 {
//                     st.pop();
//                 }

//                 else{
//                     return false;
//                 }
//             }

//             // else //if( st.isEmpty() && (ch == ']'|| ch=='}'||ch ==')'))
//             // {
//             //    return false;
//             // }

//         }

//         if(!st.isEmpty()) return false;
        
//         return true;
        
//     }
// }

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else {
                if(st.isEmpty()) return false;

                char top = st.pop();

                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
