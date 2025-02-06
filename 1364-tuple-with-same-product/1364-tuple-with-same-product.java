//No of tupleas will be multiple of 8 = 4C1
//Iterate through all pairs 
//(\U0001d44e,\U0001d44f)
//(a,b) and store the product a * b in a hashmap.
//The hashmap stores the frequency of each product.
import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;
        int result = 0;

        // Step 1: Compute all pair products and store in HashMap
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        // Step 2: Compute valid tuples from product frequency
        for (int freq : productCount.values()) {
            if (freq > 1) {
                result += (freq * (freq - 1) / 2) * 8;  // Multiply by 8 for all permutations
            }
        }

        return result;
    }
}
