//count distinct elements
//sort

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        //  int count = 1;
        //  for(int i= 1; i<nums.length ; i++){
        //     if(nums[i] != nums[i-1]){
        //        nums[count] = nums[i];
        //        count++;
        //     }
        //  }
        //  return nums[count-k];
        return nums[n-k];
    }
}