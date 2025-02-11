class Solution {
    public String clearDigits(String s) {
         
        // int n = s.length();
        Stack<Character> st = new Stack<>();
        String res = "";

        for(int i =0; i<s.length(); i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                if(st.size()>0 && !Character.isDigit(st.peek()))
                {
                    st.pop();
                }
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        
        while(!st.isEmpty())
        {
            res = st.pop()+res;
        }

    return res; 
    }
}