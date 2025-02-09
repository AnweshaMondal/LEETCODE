class Solution {
    public int maxAscendingSum(int[] nums) {
        int  sum = 0;
        int inlen = 1;
        int maxlen = 1;
        int i = 0;
        int j = 1;
        int maxsum = 0;

         while(i<nums.length )
        {
            while(j<nums.length && nums[j-1]<nums[j])
            {
                // inlen++;
                j++;
            }

            // if(inlen >= 1)
            {
                for(int k = i ; k<j; k++ )
                    {
                        sum+= nums[k];
                    }
                    maxsum = Math.max(sum, maxsum);
                    sum = 0;
            }

            //in case the adjacent 2 elements are equal or less than the previous one
            // while(j<nums.length && nums[j-1]>=nums[j]) 
            // {
            //     j++;
            // }->TLE
                i = j;
                j = i+1;
            
        }

        return maxsum;
    }
}

// class Solution {
//     public int maxAscendingSum(int[] nums) {
//         int maxsum = nums[0];
//         int sum = nums[0];

//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > nums[i - 1]) {
//                 sum += nums[i];  // Keep adding in ascending order
//             } else {
//                 sum = nums[i];  // Reset the sum for a new sequence
//             }
//             maxsum = Math.max(maxsum, sum);
//         }

//         return maxsum;
//     }
// }
