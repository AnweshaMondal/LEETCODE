// class Solution {
//     public void moveZeroes(int[] nums) {
//         int nz = 0;
//         for(int i=0; i<nums.length; i++){
//             if(nums[i]!=0){
//                 int temp = nums[i];
//                 nums[i] = nums[nz];
//                 nums[nz] = temp;
//                 nz++;
//             }
//             // else{
//             //     continue;
//             // }
//         }
//     }
// }

class Solution {
    public void moveZeroes(int[] nums) {

        int l = 0;
        int r = 0;

        while(r<nums.length && l<nums.length){
            
            if(nums[r] != 0){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
              r++;
        }
    }
}