// Identify positions where s1[i] != s2[i].
// If there are more than 2 such positions, return false (cannot fix with one swap).
// If exactly 2 positions are different, the mismatch characters must be swappable to make 
// s1 equal to s2.
// If there's exactly 1 mismatch, return false (a single swap cannot fix it)

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        int l = -1;
        int r = -1;
        int count = 0;
        
        for(int i = 0; i<s1.length(); i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
            {
              count ++;
              if(l== -1) l = i;
              else r = i ;
            //   if(count ==1)
            //    {
            //      l = i;
            //    }

            //  if(count ==2)
            //    {
            //     r = i;
            //    }
            }
        }

         if(count>2 || count == 1)
            {
                return false;
            }

    if (count == 0) return true;
        
    return s1.charAt(l) == s2.charAt(r) &&s1.charAt(r) == s2.charAt(l);
        
    }
}

//gpt
// class Solution {
//     public boolean areAlmostEqual(String s1, String s2) {
//         if (s1.equals(s2)) return true; // Already equal
        
//         int first = -1, second = -1;
//         int count = 0;

//         for (int i = 0; i < s1.length(); i++) {
//             if (s1.charAt(i) != s2.charAt(i)) {
//                 count++;
//                 if (count > 2) return false; // More than 2 mismatches → can't fix with one swap
//                 if (first == -1) first = i;
//                 else second = i;
//             }
//         }

//         return (count == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first));
//     }
// }

