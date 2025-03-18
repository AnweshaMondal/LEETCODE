// class Pair{
//     int step ;
//     String s ;
     
//     Pair(int step,String s)
//     {
//         this.step = step;
//         this.s = s;
//     }
// }

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        // Convert wordList into a HashSet for faster lookups
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        //BFS
        Queue<String>q = new LinkedList<>();
        int step = 1;
        q.add(beginWord);

        while(!q.isEmpty())
        {
           int size = q.size();

           //process all words at current level
           for(int i = 0; i<size ; i++)
           {
           String s = q.poll();
            if(s.equals(endWord))
                 {
                    return step;
                 }

           // Generate all possible next words by changing one letter at a time
             for(int j =0; j<s.length(); j++)
             {
              char arr[] = s.toCharArray();
               
               for(char c = 'a'; c<='z'; c++)
               {

                 arr[j] = c;
                 String newWord=new String(arr);

                //  if(newWord.equals(endWord))
                //  {
                //     return step+1;
                //  }
                 if(set.contains(newWord))//add all valid neighbours ie who are in the list
                 {                        //process it when poped
                    q.add(newWord);
                    set.remove(newWord);
                 }

               }
             }
           }
           step ++;
        }
      return 0;
    }
}