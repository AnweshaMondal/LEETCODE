class Solution {
    public int countPalindromicSubsequence(String s) {
        
      int n = s.length(); 
      HashSet<String> set = new HashSet<>();
      HashSet<Character> letters = new HashSet<>();

      for(char ch : s.toCharArray()) //insert all chars that has occurred in input String
      {
          letters.add(ch);
      }
       
      for (Character c : letters)
      {
         
        int f = -1;
        int l = -1;

        for(int j = 0 ; j<n ;j++)
        {
            if(s.charAt(j)== c)
            {
                if(f==-1) f = j;
                l = j;//iterate to the last occurred c in the String
            }
        }

         if(l-f >1)
            {
                //count all unique palindrome substrings
                // Set<Character> between = new HashSet<>();
                for(int k=f+1 ;k<l ;k++)
                {
                    set.add(""+s.charAt(f)+s.charAt(k)+s.charAt(l));//s.charAt(f) + s.charAt(k) + s.charAt(l) performs integer addition because char values are treated as ASCII integers when added.
                                                                    //add an empty string
                }
               
            }

      }

      return set.size();
    }
}