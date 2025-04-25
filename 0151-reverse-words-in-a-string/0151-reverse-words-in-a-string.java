class Solution {
    public String reverseWords(String s) {
        
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();

        for(int i = 0 ; i<n ; i++)
        {
            char c = s.charAt(i);
            if (c!=' ')
            {
               sb.append(c);
            }
            else
            {
               if(!sb.isEmpty()) //if(sb.length() > 0)
               {
                 words.add(sb.toString());
                 //Reset sb->Method 1
                 sb = new StringBuilder();
                 //Reset sb->Method 2
                //  sb = sb.setLength(0);
               }
            }
        }
        //append the last word, when the loop gets finished
        if(sb.length()>0) 
        {
            words.add(sb.toString());
        }


        // Reverse the word list
        // Collections.reverse(words);
        //Manual method
        int l = 0; 
        int r = words.size()-1;
        while(l<r)
        {
            String temp = words.get(l);
            words.set(l , words.get(r));
            words.set(r,temp);
            l++;
            r--;
        }

        //Join them to a sentence
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<words.size(); i++)
        {
            res.append(words.get(i));
            if(i!= words.size()-1)
            {
                res.append(" ");
            }
        }
        return res.toString();

        // return String.join(" ", words);
    }
}