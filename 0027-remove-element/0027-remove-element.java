class Solution {
    public int removeElement(int[] nums, int val) {
         
        int i =0;//the pointer that will traverse the array till the end
        int k = 0;// k will keep track of the number of the non-val elements

        while(i<nums.length)
        {
           if(nums[i] != val)
           {
             nums[k++] = nums[i++];
             //increment both the pointers i and k together  
           }
           else
           {
               i++;
           }
        }

    return k;
    }
}