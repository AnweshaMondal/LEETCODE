class Solution {
    public boolean check(int[] nums) {
        
        int pos = 0;
        int n = nums.length;

        //find the starting index of the array before rotation
        for(int i = 1; i<nums.length; i++)
        {
            if(nums[i-1]>nums[i])
            {
             pos = i; //find the position of 
              break;
            }
        }
        
        int i = 0;
        
        while( i < nums.length-1)
        {
            if ( nums[(pos+i)%n] > nums[(pos+i+1)%n])
            {
                return false;
            }

            i++;
            
        }
    
    return true;

    }
}