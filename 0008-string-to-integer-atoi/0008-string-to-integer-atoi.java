// Summary:
// Always increment i after reading a character.
// Handle whitespace and sign only once.
// Use (int) to cast long to int.
// Use Character.isDigit() instead of c >= '0' && c <= '9' for better readability.
//Don't forget to increment in a while loop

class Solution {
    public int myAtoi(String s) {
        
        int flag = 0;
        long res = 0L;
        int i = 0;
        int n = s.length();

    //skip the leading white spaace-> always include a check ie i<n in such while loop
        while(i<n && s.charAt(i)==' ')
        {
            i++;
        }

    //Evaluate the sign after the white space
    if(i<n && s.charAt(i) == '-')
    {
        flag = 1;
        i++;
    }else if(i<n && s.charAt(i)=='+'){
         i++; 
        }

    //Evaluate the the characters thereafter
    while(i<n && Character.isDigit(s.charAt(i)))
    {
       res = res *10 + (s.charAt(i)-'0');
       
    if(flag == 0 && res>Integer.MAX_VALUE)
    {
        return Integer.MAX_VALUE;
    }

    else if(flag==1 && -res<Integer.MIN_VALUE)
    {
        return Integer.MIN_VALUE;
    }

       i++;
    }

    
    if(flag == 1) //negative number
    {
        res = -res;
    }
    
    return (int)res;

    }
}

// class Solution {
//     public int myAtoi(String s) {
//         int flag = 0;
//         long res = 0L;
//         int i = 0;
//         int n = s.length();

//         // Step 1: skip the leading white space
//         while (i < n && s.charAt(i) == ' ') {
//             i++;
//         }

//         // Check if string is empty after whitespaces
//         if (i >= n) return 0;

//         // Step 2: Evaluate the sign after the whitespace
//         if (s.charAt(i) == '-') {
//             flag = 1;
//             i++;
//         } else if (s.charAt(i) == '+') {
//             i++;
//         }

//         // Step 3: Evaluate the characters thereafter
//         while (i < n && Character.isDigit(s.charAt(i))) {
//             res = res * 10 + (s.charAt(i) - '0');

//             // Step 4: Clamp the result early if out of bounds
//             if (flag == 0 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//             if (flag == 1 && -res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

//             i++;
//         }

//         if (flag == 1) {
//             res = -res;
//         }

//         return (int) res;
//     }
// }
