// class Solution {
//     public int longestMonotonicSubarray(int[] arr) {
//         int len = arr.length;
//         if (len == 0) return 0;
//         if (len == 1) return 1;

//         int maxLen = 1; // Minimum length is 1
//         int i = 0;

//         while (i < len - 1) {
//             int j = i;

//             // Strictly Increasing Subarray
//             while (j < len - 1 && arr[j] < arr[j + 1]) {
//                 j++;
//             }
//             maxLen = Math.max(maxLen, j - i + 1);
//             i = j; // Move i to j for the next segment

//             // Strictly Decreasing Subarray
//             while (j < len - 1 && arr[j] > arr[j + 1]) {
//                 j++;
//             }
//             maxLen = Math.max(maxLen, j - i + 1);
//             i = j; // Move i to j for the next segment

//             // Skip duplicate elements
//             while (j < len - 1 && arr[j] == arr[j + 1]) {
//                 j++;
//                 i++;
//             }
//         }

//         return maxLen;
//     }
// }

//Using a asingle loop
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1; 
        int incLen = 1, decLen = 1; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++; // Increase increasing sequence count
                decLen = 1; // Reset decreasing sequence
            } else if (nums[i] < nums[i - 1]) {
                decLen++; // Increase decreasing sequence count
                incLen = 1; // Reset increasing sequence
            } else {
                // Reset both when numbers are equal
                incLen = 1;
                decLen = 1;
            }

            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }

        return maxLen;
    }
}

