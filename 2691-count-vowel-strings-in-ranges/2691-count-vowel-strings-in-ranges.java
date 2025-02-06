// class Solution {
//     public int[] vowelStrings(String[] words, int[][] queries) {
          
//           int [] ans = new int[queries.length];

//           for(int i = 0 ; i<queries.length ; i++)
//           {
//               int[] row = queries[i];

//               int l = row[0];
//               int r = row[1];
//               int count = 0;

//               for(int k = l ; k<=r ; k++)
//               {
//                  String str = words[k];
//                  int n = str.length()-1;
                
//                  if((str.charAt(0)=='a'|| str.charAt(0)=='e'||str.charAt(0)=='i'||str.charAt(0)=='o'||str.charAt(0)=='u')
//                  &&
//                  (str.charAt(n)=='a'|| str.charAt(n)=='e'||str.charAt(n)=='i'||str.charAt(n)=='o'||str.charAt(n)=='u'))
//                  {
//                     count+=1;
//                  }
//               }
//               ans[i] = count;
//           }          

//           return ans;
//     }
// }//->Giving TLE for last test case

//by prefix sum
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
          
           int[] prefix = new int[words.length+1];
           int[] ans = new int[queries.length];

           for(int i = 0; i<words.length; i++)
           {
             String word = words[i];
             int sts = isVowelString(word)? 1:0; //\U0001f642ternary operator
             prefix[i+1] = prefix[i] + sts;
            }


            for(int i = 0; i<queries.length; i++)
            {
               int[] row = queries[i];
               int f = row[0];
               int l = row[1];
               ans[i] = prefix[l+1] - prefix[f];

            }
        return ans;
    }



    boolean isVowelString(String s){
        int n = s.length()-1;
        return isVowel(s.charAt(0))&& isVowel(s.charAt(n));
    }



    boolean isVowel(char ch){

        // HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        // return (vowels.contains(ch));//O(1) TC

        //else use inbuilt function
        String str = "aeiou";
        return str.indexOf(ch) != -1;//indexOf(ch) is a built-in method in Java that checks if a character (ch) exists in a string.
                                     //return type = index else -1 if does not exist
        
    }
}