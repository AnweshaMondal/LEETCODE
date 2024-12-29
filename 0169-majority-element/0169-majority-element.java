//:)
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         int n = nums.length;
//         return nums[n/2];
//     }
// }

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int sol = nums[0];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

       for(int i = 0 ; i<nums.length; i++){

        if(!map.containsKey(nums[i])){
           map.put(nums[i],1);
          }
         else{
            count = 0;
            count = map.get(nums[i])+1;
           if(count > nums.length/2){
            sol = nums[i];
            break;
           }
           map.put(nums[i], count);//1->key, 2->value 
         }
         
       }

   return sol;
    }
}