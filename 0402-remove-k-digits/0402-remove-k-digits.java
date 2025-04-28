// class Solution {
//     public String removeKdigits(String s, int k) {
        
//         Stack<Character> st = new Stack<>();
//         st.add(s.charAt(0));

//         // if(k>s.length()) return"0";

//         for(int i = 1; i<s.length(); i++)
//         {
//             while(k>0 && !st.isEmpty() && st.peek()>s.charAt(i))
//             {
//                 st.pop();
//                 k--;
//             }


//             st.push(s.charAt(i)); //push the current char


//             //remove leading 0
//             if(st.size() == 1 && st.peek() == '0')
//             {
//                st.pop();
//             }
//         }
//         //in case the string ended but k didn't turned 0 :Example-3
//         while(k>0 && !st.isEmpty())
//         {
//             st.pop();
//             k--;
//         }

//     //Form the number by emptying the Stack, then reverse it
//     StringBuilder sb = new StringBuilder();
//     while(!st.isEmpty())
//     {
//         sb.append(st.pop());
//     }

//     sb.reverse();
//     String res = sb.toString();
//     if (res.isEmpty()) return "0";
//     return res;


//     }
// }

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        // If k is still left
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Build the number
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        // Remove leading zeros
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        String result = sb.substring(idx);

        return result.isEmpty() ? "0" : result;
    }
}
