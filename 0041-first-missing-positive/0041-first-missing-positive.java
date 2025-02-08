// class Solution {
//    boolean present = false;
//     public int firstMissingPositive(int[] nums) {
//        int misPositive = 1; //cause +ve int starts from 1
//     //sort the array
//     // Arrays.sort(nums);

// for(int j= 0; j<nums.length ; j++){
//      for(int i= 0; i<nums.length ;i++){
//         //Linear serach
//      if(misPositive == nums[i]){
//        present = true;
//        break;
//      }    
//  }
//      if(present == true){
//         misPositive++ ;
//         present= false;
//      }
//      else{
//         return misPositive;
//      }
// }

//      return misPositive;
//     }
        
// }



class Solution {

    public int firstMissingPositive(int[] nums) {
      
    //   int min = Integer.MAX_VALUE;
    //   int max = Integer.MIN_VALUE;
    //   int missing = 1;
    //   //determine lower and upper boundary
    //   for(int i = 0; i<nums.length; i++)
    //   {
    //     //Find Min of the Array:
    //       if(nums[i]<min)
    //       {
    //         min = nums[i];
    //       }

    //       //Find max of the Array:
    //       if(nums[i]>max)
    //       {
    //         max = nums[i];
    //       }
    //   }

    //   //if the min >1->return 1
    //   if(min>1)
    //   {
    //     return 1;
    //   }
      
      //Since the smallest missing positive integer is always in the range [1, n+1]
      //(where n = nums.length), we can rearrange the numbers in-place to their correct 
      //indices using Cyclic Sort.
      //Cyclic Sort (O(n) time
      int n = nums.length;
      int i=0;
      

      while(i<n)
      {
        if(nums[i]>0 && nums[i]<n && nums[i] != nums[nums[i]-1])
        {
         int index = nums[i]-1;
         int temp = nums[index];
         nums[index] = nums[i];
         nums[i] = temp;
        }

        else
        {
          i++;
        }
    }

      for ( i = 0; i<nums.length; i++)
      {
        if(nums[i] != i+1)
        {
            return i+1;
        }
      }

     return n+1;
    }
}