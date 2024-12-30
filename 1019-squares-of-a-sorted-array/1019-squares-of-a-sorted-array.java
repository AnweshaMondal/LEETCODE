// //Brute Force
// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         for(int i = 0; i< nums.length ;i++){
//             int sq = nums[i]*nums[i];
//             nums[i] = sq;
//         }
//         Arrays.sort(nums);//returns void
//         return nums;
//     }
// }

////Two Pointer
class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0; 
        int r = nums.length-1;
        int result[] = new int[nums.length]; //new solution array

        for(int i = nums.length-1 ; i>=0 ;i--){

            if(Math.abs(nums[r]) >= Math.abs(nums[l])){
                result[i] = nums[r]*nums[r];
                r--;
            }
            else{
               result[i] = nums[l]*nums[l];
                l++;
            }
        }
        return result;
    }
}

