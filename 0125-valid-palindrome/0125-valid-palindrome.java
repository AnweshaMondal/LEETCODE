class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while(l<=r){
            if(l<r &&!isAlphaNumeric(s.charAt(l))){
             l++;
            }

            else if(l<r && !isAlphaNumeric(s.charAt(r))){ //independent if, not else if, 
                                                     //both may be executed in the same iteration simultaneously
             r--;
            }

            else if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            else{
            l++;
            r--;
            }
        }
       return true;  // Return true if the loop completes
    }

    boolean isAlphaNumeric(char c){
        return (c >= 'a' && c <= 'z') || 
               (c >= 'A' && c <= 'Z') || 
               (c >= '0' && c <= '9');
    }

}