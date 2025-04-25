class Solution {
    public String addStrings(String num1, String num2) {
        
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(i>=0 || j>=0 || carry>0)
        {
            int sum = 0;//for summation of a single digit position
            if(i>= 0)
            {
            int d1 = num1.charAt(i);
            sum+= d1-'0';
            }
            if(j>=0)
            {
            int d2 = num2.charAt(j);
            sum+= d2-'0';
            }
            //add carry to the sum
            sum+= carry;
            //update carry and sum
            carry = sum/10;
            sum = sum % 10;
            
            sb.append(sum);
            //update i and j 
            i--;
            j--;
        }

        //reverse the stringbuilder
        sb.reverse();
        return sb.toString();
    }
}