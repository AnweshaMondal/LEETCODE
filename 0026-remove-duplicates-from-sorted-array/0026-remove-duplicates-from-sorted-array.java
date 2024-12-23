// //for loop is the fastest
// class Solution {
//      public int removeDuplicates(int[] nums) {
//         int count = 0;
//         for(int i=1 ; i<nums.length; i++){
//             if(nums[i]==nums[i-1]){
//                 continue;//do nothing, no code execution
//             }
//             else{
//                 // i.e. when the consecutive 2 elements are unique
//                 nums[count] = nums[i-1];
//                 count++; 
//             }
//         }
//          //the last elements into the next position
//             nums[count]= nums[nums.length-1];
//             count++;
//     return count;
//     }
// }

// class Solution {
//      public int removeDuplicates(int[] nums) {
//         int count = 1;
//         int replace = 1; //it can only start from 2nd pos in the array
//         for(int  i=1; i<nums.length ;i++){
//             if(nums[i]!=nums[i-1]){
//                nums[replace]=nums[i];
//                count++;
//                replace++;
//             }
            
//         }
//         return count;      
//      }
// }

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length - count; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;

                // Shift elements to the left
                for (int j = i; j <= nums.length-count; j++) {
                    nums[j - 1] = nums[j];
                }

                i--; // Decrement `i` to recheck the current position after shifting
            }
        }
        return nums.length - count;
    }
}
