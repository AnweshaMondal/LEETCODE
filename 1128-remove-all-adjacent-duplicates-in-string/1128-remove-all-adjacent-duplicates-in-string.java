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
                //always add a check before while loop like (i<n)
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
// }--> not working


//By using Stack and String Builder
// class Solution {
//     public String removeDuplicates(String s) {
//         StringBuilder sb = new StringBuilder();
        
//         for (char ch : s.toCharArray()) {
//             int len = sb.length();
//             if (len > 0 && sb.charAt(len - 1) == ch) {
//                 sb.deleteCharAt(len - 1); // Remove the duplicate
//             } else {
//                 sb.append(ch);
//             }
//         }
        
//         return sb.toString();
//     }
// }

//Stack solution
class Pair{

    char ch;
    int count ;

    Pair(char ch, int count)
    {
        this.ch = ch;
        this.count = count;
    }

}

class Solution {
    public String removeDuplicates(String s) {

    // Stack<Character, count> = new Stack<>();
    // In Java, Stack only takes one type parameter like:Stack<Character> = new Stack<>()
     
     Stack<Pair> st = new Stack<>();
     int n = s.length();

     for(int i = 0; i<n; i++)
     {
        char ch = s.charAt(i);

        if(st.isEmpty())
        {
            st.push(new Pair(ch, 1));
        }
        else //the stack is not empty
        {
           if(st.peek().ch != ch)
           {
            st.push(new Pair(ch,1));
           }

           else
              {
                st.pop();
              }
        }
     }

     //return the String 
     if(st.isEmpty())
     {
        return "";//null string
     }

   //We shall use StringBuilder
    StringBuilder res = new StringBuilder();

     while(!st.isEmpty())
     {
        Pair var = st.pop();
        int count = var.count;
        for(int j= 0; j<count; j++)
        {
          res.insert(0,var.ch);//to insert element at the front of the sb  
        }
     }
    return res.toString();

    }
}