// class Solution {
//     public int maxScore(String s) {
        
//         int leftzeroes = 0;
//         int totalones = 0;
//         int maxscore = 0;

//         for(int i = 0; i<s.length(); i++)
//         {
//             if(s.charAt(i)=='1')
//             {
//                 totalones+=1;
//             }
//         }

//         for(int i = 0; i<s.length()-1; i++)//right most element must be left
//         {
//            if(s.charAt(i)=='0')
//            {
//             leftzeroes +=1;
//            }
//            else{
//             //s.chatAt(i)=='1'
//             totalones--;
//            }

//            int score = leftzeroes + totalones;
//            maxscore = Math.max(score,maxscore); 
//         }

//         return maxscore;
//     }
// }

public class Solution {
    public int maxScore(String s) {
        int maxScore = 0;
        int countZerosLeft = 0;
        int countOnesRight = (int) s.chars().filter(ch -> ch == '1').count();


        for (int i = 0; i < s.length() - 1; i++) {
            countZerosLeft += s.charAt(i) == '0' ? 1 : 0;
            countOnesRight -= s.charAt(i) == '1' ? 1 : 0;
            maxScore = Math.max(maxScore, countZerosLeft + countOnesRight);
        }

        return maxScore;
    }
}