//Brute Force:

// class Solution {
//     public long countBadPairs(int[] nums) {

//         long totalCount = 0;
//         long n = nums.length;
//         //generate all pairs by nested loop

//         for(int i =0; i<n-1 ;i++)
//         {
//             for(int j =i+1 ; j<n ;j++)
//             {
//                 if( (j-i) != (nums[j]-nums[i]) )
//                 {
//                     totalCount++;
//                 }
//             }
//         }
//        return totalCount ;
//     }
// }

//j−i=nums[j]−nums[i]
//nums[j]−j=nums[i]−i = key
//If key is the same for two indices, the pair is good. Otherwise, it's bad.


class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2; // Total pairs

        HashMap<Integer, Long> map = new HashMap<>();
        long goodPairs = 0;

        for (int i = 0; i < n; i++) 
        {
            int key = nums[i] - i;

            // Count how many times we've seen this key before
            if (map.containsKey(key))
            {
                goodPairs += map.get(key);
            }

            // Update the count of the key
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }

        return totalPairs - goodPairs;
    }
}
