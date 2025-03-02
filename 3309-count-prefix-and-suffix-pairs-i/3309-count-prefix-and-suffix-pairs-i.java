class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for(int i = 0; i<words.length; i++)
        {   
            for(int j= i+1 ; j<words.length; j++)
            {
                if(i != j)
                {
                  if(isPrefixAndSuffix(words[i],words[j]))
                  {
                    count ++;
                  }
                }
            }
        }

     return count;
    }

    boolean isPrefixAndSuffix(String str1, String str2)
    {
          int len1 = str1.length();
          int len2 = str2.length();
          int suffixStart = len2-len1;

          if(len1>len2) return false;
          //if len1 <len2 , ie str1 can be a substring
          if(str2.substring(0,len1).equals(str1) && str2.substring(suffixStart).equals(str1))
          {
            return true;
          }

        return false;
    } 
}