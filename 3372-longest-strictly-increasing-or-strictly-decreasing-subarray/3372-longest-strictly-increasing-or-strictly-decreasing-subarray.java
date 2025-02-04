class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxlen = 1;
        int i = 0;
        int len = 1;

        if(nums.length == 0)
        {
            return 0;
        }


        while(i<nums.length-1)
        {
            int j = i;
            while(j<nums.length-1 && nums[j]<nums[j+1])
            {
                len++;
                j++;
            }

            maxlen = Math.max(maxlen,len);
            len = 1;
            i = j;
            while(j<nums.length-1 && nums[j]>nums[j+1])
            {
                len++;
                j++;
            }

            maxlen = Math.max(maxlen,len);
            len = 1;
            i = j;
            //Skip the duplicate values
            while(j<nums.length-1 && nums[j]== nums[j+1])
            {
                j++;
                i++;
            }

        }

        return maxlen;
    }
}