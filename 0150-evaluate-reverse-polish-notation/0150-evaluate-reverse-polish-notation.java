class Solution {
    public int evalRPN(String[] tokens) {
      
      Stack<Integer> st = new Stack<>();

      int n = tokens.length;
      
      for(int i = 0; i<n ; i++)
      {
        if(tokens[i].equals("+"))
        {
            int second = st.pop();
            int first = st.pop();
            st.push(first+second);
        }
        
        else if(tokens[i].equals("-"))
        {
            int second = st.pop();
            int first = st.pop();
            st.push(first - second);
        }

        else if(tokens[i].equals("*"))
        {
            int second = st.pop();
            int first = st.pop();
            st.push(first*second);
        }

        else if(tokens[i].equals("/"))
        {
            int second = st.pop();
            int first = st.pop();
            st.push(first/second);
        }
        else{
            st.push(Integer.parseInt(tokens[i]));
        }

      }

      return st.pop();
      
    }
}