class Solution {
    public int minBitFlips(int start, int goal) {
        
        int result = start^goal;
        int count = 0;
        //Count the number of 1 in the binary of result  
        while(result>0)
        {
            int rem  = result % 2;
            if(rem == 1) count++;
            result = result/2;
        }
    return count;
    }
}