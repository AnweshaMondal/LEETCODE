class Solution {
    public int pivotIndex(int[] nums) {
        
        int prefix[] = new int [nums.length];
        int sum = 0;

     //Construct the prefix sum array:
        for(int i = 0; i<nums.length; i++){
            sum = sum +nums[i];
            prefix[i] = sum;    
        }
       
        sum = 0; //reset sum as 0 
        for(int i = 0; i<nums.length; i++){
              
            if(sum == prefix[nums.length-1]-prefix[i]){
                return i;
            }

            sum = prefix[i];
        }
         return -1;
    }
}