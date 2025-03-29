class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i = 1;
        int k = 1;
        
        while(i<nums.length)
        {
            if(nums[i] == nums[i-1])
            {
              i++;
            }
            else //ie the cosecutive elements are not equal
            {
               nums[k++] = nums[i++];
            }
        }

        return k;
    }
}