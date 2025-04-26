 class Pair{
    
    char ch;
    int occurrence;
    Pair(char c , int count)
    {
        this.ch = c;
        this.occurrence = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        
       Stack<Pair> st = new Stack<Pair>();
       int n = s.length();
       
       for(int i = 0; i<n; i++)
       {
         char ch = s.charAt(i);

         if(st.isEmpty())// if teh stack is emptu push the character with occurrence = 1
         {
            st.push(new Pair(ch, 1));
         }

         else
         {
            if(st.peek().ch != ch )
            {
                st.push(new Pair(ch, 1));
            }
            else
            {
                st.peek().occurrence++;
                if(st.peek().occurrence == k)
                {
                    st.pop();
                }
            }
         }
       }

    //Convert the content of Stack back to the String
      if(st.isEmpty()) return "";

      StringBuilder res = new StringBuilder(); 

    while (!st.isEmpty()) 
    {
       Pair var = st.pop();
       int count = var.occurrence;  // fixed spelling: occurrence
       for (int j = 0; j < count; j++) 
       {
         res.insert(0, var.ch);   // fixed how you add char to StringBuilder
       }
    }

   return res.toString();

    }
}