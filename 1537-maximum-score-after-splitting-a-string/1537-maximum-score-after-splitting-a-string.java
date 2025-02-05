class Solution {
    public int maxScore(String s) {
        
        int leftzeroes = 0;
        int totalones = 0;
        int maxscore = 0;

        for(int i = 0; i<s.length(); i++)
        {
            if(s.charAt(i)=='1')
            {
                totalones+=1;
            }
        }

        for(int i = 0; i<s.length()-1; i++)//right most element must be left
        {
           if(s.charAt(i)=='0')
           {
            leftzeroes +=1;
           }
           else{
            //s.chatAt(i)=='1'
            totalones--;
           }

           int score = leftzeroes+totalones;
           maxscore = Math.max(score,maxscore); 
        }

        return maxscore;
    }
}