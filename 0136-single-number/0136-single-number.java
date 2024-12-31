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

 class Solution {
     public int singleNumber(int[] nums) {
        int singlenum=0;
for(int i=0; i<nums.length ; i++){
    int count=1;
    for(int j=0; j<nums.length ;j++){
        if(i != j && nums[i]==nums[j]  ){
            count++;
            break;
        }
    }
        if(count == 1){
          singlenum = nums[i];
        
        }
    }
   return singlenum; 
}

 }