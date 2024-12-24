// class Solution {
//     public int removeElement(int[] nums, int val) {
//         // int valcount=0;
//         int unique_pos=0;
//         for(int i=0; i<nums.length ;i++){
//             if(nums[i]==val){
//                 continue;
//             }
//             else{
//                 //i.e. the current element is not val
//                 nums[unique_pos]=nums[i];
//                 unique_pos++;
//             }
//         }
//         return unique_pos;
//     }
// }

class Solution {
    public int removeElement(int[] nums, int val) {

        int count = 0;

        for(int i = 0 ; i<nums.length ; i++){
             if(nums[i] != val){
                nums[count] = nums[i];
                count++;
             }
        }
        return count;
    }
}