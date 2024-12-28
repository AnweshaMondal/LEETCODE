class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> st = new HashMap<>();
        HashMap<Character,Character> ts = new HashMap<>();
       
       if(s.length()!= t.length()){
            return false;
         }

        if(s==""&&t==""){
            return true;
        }

        for(int i = 0 ; i<s.length(); i++){
                
         char c1 = s.charAt(i);
         char c2 = t.charAt(i);

         if(st.containsKey(c1)&& st.get(c1)!=c2){
            return false;
            }else{
        st.put(c1,c2);
          }
        

        if(ts.containsKey(c2)&& ts.get(c2)!=c1){
        return false;
        }else{
         ts.put(c2,c1);
        }
    
    }
       
        return true;
    }
}