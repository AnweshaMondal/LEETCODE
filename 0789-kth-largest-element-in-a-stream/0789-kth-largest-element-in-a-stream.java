// class KthLargest {

//    PriorityQueue<Integer> pq ;
//    int k ;

//     public KthLargest(int k, int[] nums) {
//         pq = new PriorityQueue<>();
//         this.k = k;

//         for(int num:nums)
//         {
//             add(num);
//         }
//     }
    
//     public int add(int val) {
        
//         pq.add(val);

//         if(pq.size()>k)
//         {
//             pq.poll();
//         }
 
//     return pq.peek();
        
//     }
// }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        // Build heap using private method without return
        for (int num : nums) {
            addToHeap(num);
        }
    }

    private void addToHeap(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public int add(int val) {
        addToHeap(val);  // Reuse logic
        return minHeap.peek();  // Always kth largest
    }
}
