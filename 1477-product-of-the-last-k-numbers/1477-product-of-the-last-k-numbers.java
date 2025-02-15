// class ProductOfNumbers {
   
//     List<Integer> list;

//     public ProductOfNumbers() {
//         list = new ArrayList<Integer>();
//     }
    
//     public void add(int num) {
//         list.add(num);
//     }
    
//     public int getProduct(int k) {
//         int product =1;
//         for(long i = list.size()-1; i>=list.size()-k; i--)
//         {
//             product *= list.get(i);
//         }
//         return product;
    // }
// }//showing TLE

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

 class ProductOfNumbers {
    List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1); // Initial product is 1
    }
    
    public void add(int num) {
        if (num == 0) {
            // Reset the list when zero is added
            // prefixProduct = new ArrayList<>();
            prefixProduct.clear();
            prefixProduct.add(1);
        } else {
            // Multiply the last prefix product with the new number
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (k >= size) return 0; // If k is more than stored numbers, return 0
        
        // Compute product using division
        return prefixProduct.get(size - 1) / prefixProduct.get(size - 1 - k);
    }
}