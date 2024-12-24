class Solution {
    public int lengthOfLastWord(String s) {
        
        //edge case:empty string
        if( s =="" ){
            return 0;
        }

        int n  = s.length();
        int i = n-1;
        int len= 0;

        //if there are spaces at the end
        while(s.charAt(i)== ' '){
            i-- ;
        }

        //loop from behind
        while(  i>=0 && s.charAt(i)!= ' '){
            len +=1;
            i--;
        }
        return len;
    }
}