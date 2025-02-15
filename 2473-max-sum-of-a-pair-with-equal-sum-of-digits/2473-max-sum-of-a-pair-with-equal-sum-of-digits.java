// class Solution {
//     public int maximumSum(int[] nums) {
    
//     HashMap<Integer, Integer> map = new HashMap<>();
//     int maxSum = -1;

//    for(int i = 0; i<nums.length; i++)
//    {
//       for(int j = i+1; j<nums.length ;j++)
//       {
//          if (digitSum(nums[i]) == digitSum(nums[j]))
//          {
//              maxSum = Math.max(maxSum,nums[i]+nums[j]);
//          }
//       }
//    }

//    return maxSum;      
//     }

//     int digitSum(int num){

//         int sum = 0;
//         while(num>0)
//         {
//            sum = sum+num%10;
//            num = num/10;
//         }
//         return sum;
//     }
// } //TLE

class Solution {
    public int maximumSum(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int maxSum = -1;

        for(int i =0; i< nums.length; i++)
        {
            int num = nums[i];
            int sum = digitSum(num);
            if(map.containsKey(sum))
            {
              int pair = map.get(sum);
              maxSum = Math.max(pair+num,maxSum);
              //update map with the highest number
              map.put(sum, Math.max(pair, num));
            }
            else{
                map.put(sum, num);
            }
        }
        return maxSum;
    }


    int digitSum(int num){
        int sum = 0;

        while(num>0)
        {
           sum = sum+num%10;
           num = num/10;
        }
        return sum;
    }
}
    