import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        
        // Iterate through each character from 'a' to 'z'
        for (char c = 'a'; c <= 'z'; c++) {
            int first = -1, last = -1;
            
            // Find first and last occurrence of character 'c'
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    if (first == -1) first = i; // First occurrence
                    last = i; // Always update last occurrence
                }
            }
            
            // If we have at least one character in between
            if (first != -1 && last != -1 && last - first > 1) {
                HashSet<Character> uniqueMiddles = new HashSet<>();
                
                // Count unique middle characters
                for (int j = first + 1; j < last; j++) {
                    uniqueMiddles.add(s.charAt(j));
                }
                
                count += uniqueMiddles.size();
            }
        }
        
        return count;
    }
}
