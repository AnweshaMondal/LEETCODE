class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i =0; i<nums.length; i++){
            
            if(!set.contains(nums[i])){   //for HashMap-containsKey
                set.add(nums[i]);
            }else{
                return true;
            }
        }
        return false;
    }
}

//HASH- SET  is a special data strucyure that never contains any duplicate
//declare an interger Hast-Set

// class Solution {
//     public boolean containsDuplicate(int[] nums) {
// Set<Integer> hashmap = new HashSet<>();

// //traverse the array
// for(int i= 0; i< nums.length ; i++){
//  if(hashmap.contains(nums[i])){
//     return true;
//  }
//  else{
//     hashmap.add(nums[i]);
//  }
// }
//  return false;
//     }
// }