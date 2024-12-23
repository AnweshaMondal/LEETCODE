//linear search
// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         for(int i=0; i<nums.length; i++){
//             if(nums[i]>=target){
//                 return i;
//             }
//         }
//         //in case the number is not found
//         // for(int i=0 ;i<nums.length ;i++){
//         //     if(nums[i] > target){
//         //     return i;
//         //     }
//         // }
// //if it is inserted at last , i.e array index out of bound condition
// // if(nums[nums.length-1] < target){
// //     return nums.length;
// //       }   
// //    
// return nums.length;           
//     }
//  }  

// //Binary Search
// class Solution{
//    public int searchInsert(int[] nums, int target) {
//     int start = 0;
//     int end = nums.length-1;
//     int index = nums.length;
//     while(start<=end){
//         int mid = start+ (end-start)/2 ;
//         if(nums[mid]>=target){
//             index = mid;
//             //check for left side for smaller index
//             end = mid - 1;
//         }
//         else{
//             //if arr[mid]< target, search space will be right part of theh array
//             start = mid+1;
//         }
//     }
//     //default return
//     return index;
//    }
// }

class Solution{
   public int searchInsert(int[] nums, int target) {
             int lft = 0;
             int ryt = nums.length -1;
             

             while(lft <= ryt){

                int mid = (ryt + lft)/2;

                if(nums[mid] == target){
                    return mid;
                }

                else if(nums[mid]>target){
                     ryt = mid -1;
                }
                else {
                    lft = mid+1;
                }
             }
              //in case not found
             
                return lft;
              
   }
}
