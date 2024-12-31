// class Solution {
//     public int singleNumber(int[] nums) {

//        int single=0;
//        Arrays.sort(nums);//inplace 

//          //if(nums.length % 2 == 0)--> this case is not possible cause the array has 
//         //to be of odd length , i.e last index is even 

//     for(int i= 1; i<nums.length ;i+=2){
//      if(nums[i]==nums[i-1]){
//         continue;
//      }
//      else{
//         single = nums[i-1];
//      }
// }
// return single;
//     }
// }

//XOR OPERATOR --> SPACE COMPLEXITY =1
//  class Solution {
//     public int singleNumber(int[] nums) { 
//        int value= 0;
//        for(int i=0; i<nums.length ;i++){
//         value= value^nums[i];
//        }
//         return value;
//     }
   
//  }

//  class Solution {
//      public int singleNumber(int[] nums) {
//         int singlenum=0;
// for(int i=0; i<nums.length ; i++){
//     int count=1;
//     for(int j=0; j<nums.length ;j++){
//         if(i != j && nums[i]==nums[j]  ){
//             count++;
//             break;
//         }
//     }
//         if(count == 1){
//           singlenum = nums[i];
        
//         }
//     }
//    return singlenum; 
// }

//  }

//HashSet
class Solution {
     public int singleNumber(int[] nums) {

        HashSet<Integer> set = new HashSet<>();        
        for(int i = 0; i< nums.length; i++){
            if(set.contains(nums[i])){
                //remove the element
                set.remove(nums[i]); 
            }
            else{
                //does not contain element
                set.add(nums[i]);
            }
        }

        // At this point, the set contains only the single element
        // Use an iterator or loop to get that single element
        for (int single : set) {
            return single;
        }
        return -1; //Default return
     }
}