class Solution {
    public List<String> stringMatching(String[] words) {
        
        List<String> list = new ArrayList<String>();
        HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i<words.length; i++)
        {
          for(int j =0; j<words.length; j++)
          {
            if(i != j )
            {
            //    if(words[j].contains(words[i]))
            //    {
            //      list.add(words[i]);
            //    }
               if(words[i].contains(words[j]) /*&& !set.contains(words[j])*/)
               {
                 set.add(words[j]);
               }
            }
          }
        }
        
        
  for (String word : set)  //set is an unordered list, does not provide element access with index
   {
    list.add(word);
   }

        return list;
    }
}