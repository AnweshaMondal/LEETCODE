//Optimal Approach: Boyer-Moore Voting Algorithm (O(n) Time, O(1) Space)
class Solution {
    public int majorityElement(int[] nums) {
        
       int candidate = nums[0];
       int count = 1;

       for(int i = 0; i< nums.length; i++)
       {
          if(nums[i]== candidate)
          {
            count++;
          }
          else
          {
            count -- ;
          }

          if(count == 0)
          {
            candidate = nums[i];
            count = 1 ;
          }
       }

       return candidate;
    }
}