class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while(l<=r){
            while(l<r &&!isAlphaNumeric(s.charAt(l))){
             l++;
            }

            while(l<r && !isAlphaNumeric(s.charAt(r))){
             r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }
       return true;  // Return true if the loop completes
    }

    boolean isAlphaNumeric(char c){
        return (c >= 'a' && c <= 'z') || 
               (c >= 'A' && c <= 'Z') || 
               (c >= '0' && c <= '9');
    }

}