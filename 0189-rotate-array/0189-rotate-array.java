class Solution {
    public void rotate(int[] nums, int k) {

      int n = nums.length;
       k = k % n; // Handle cases where k >= n
      reverse(0,n-1,nums);
      reverse(0,k-1, nums);
      reverse(k,n-1, nums);
    }

    void reverse(int left , int right, int[]nums)
    {
        while(left< right)
        {
          int temp = nums[left];
          nums[left] = nums[right];
          nums[right] = temp;
          left++;
          right--;
        }
    }
}