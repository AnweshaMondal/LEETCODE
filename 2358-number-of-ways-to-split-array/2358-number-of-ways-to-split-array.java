// class Solution {
//     public int waysToSplitArray(int[] nums) {

//       int[] prefix = new int[nums.length];  
//       prefix[0] = nums[0];
//       int n = nums.length;

//       for(int i = 1 ; i<nums.length; i++)
//       {
//         prefix[i] = prefix[i-1]+nums[i];
//       }
      
//        int totalsum = prefix[n-1];
//        int count = 0;
//        for(int i = 0; i< n-1; i++)
//        {
//           int currsum = totalsum - prefix[i];
//           if(prefix[i] >= currsum)
//           {
//             count++;
//           }
//        }

//        return count;  
//     }
// }

class Solution {
    public int waysToSplitArray(int[] nums) {
        long leftSum = 0;  // Use long to prevent overflow
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;
            if (leftSum >= rightSum) {
                count++;
            }
        }

        return count;
    }
}
