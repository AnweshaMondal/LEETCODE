class Solution {
    public String shiftingLetters(String s, int[] shifts) {
    //   int first = 'a'; //ASCII Integer value of a char

      int totalShifts = 0;
      char[] arr = s.toCharArray();
      int n = s.length();

      for(int i = n-1; i>=0; i--)
      {
         totalShifts = (totalShifts +shifts[i])%26;
         arr[i] = (char)('a'+ (arr[i]-'a'+totalShifts)%26);
      }
     return new String(arr);
    }
}