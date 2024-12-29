//count distinct elements
//sort

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         int n = nums.length;
//         Arrays.sort(nums);

//         //  int count = 1;
//         //  for(int i= 1; i<nums.length ; i++){
//         //     if(nums[i] != nums[i-1]){
//         //        nums[count] = nums[i];
//         //        count++;
//         //     }
//         //  }
//         //  return nums[count-k];
//         return nums[n-k];//hatt faaltu qn
//     }
// }

//Priority queue
class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new  PriorityQueue<>(); //creats a min-heap

        for(int element:nums){
            q.add(element);

            //filter
            if(q.size() > k){
                q.poll(); //pop the smallest one
            }
        }
              return q.peek();
    }
}