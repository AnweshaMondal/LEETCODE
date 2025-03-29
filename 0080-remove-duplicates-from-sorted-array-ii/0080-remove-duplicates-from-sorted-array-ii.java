class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i = 1;
        int k = 1;
        int count = 1;
       
       while(i < nums.length)
       {
          if(nums[i] == nums[i-1])
          {
            count++;
            if(count > 2)//ie item occurs more than twice
            {
               i++;
               continue;//skip the code below (of the loop), start next iteration
            }
            
            nums[k] = nums[i];
            i++;
            k++; //if count<2 then incremnt k and i both together
          }

          else //ie nums[i] != nums[i-1]
          {
            count = 1;
            nums[k] = nums[i];
            k++;
            i++;
          }

       }

     return k;
    }
}