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

class Solution {
     public int removeDuplicates(int[] nums) {
        int count = 1;
        int replace = 1; //it can only start from 2nd pos in the array
        for(int  i=1; i<nums.length ;i++){
            if(nums[i]!=nums[i-1]){
               nums[replace]=nums[i];
               count++;
               replace++;
            }
            else{
                continue; //go ahead
            }
        }
        return count;      
     }
}