import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>(); // Use long to avoid integer overflow
        int operations = 0;

        // Insert all elements into the min heap
        for (int num : nums) {
            q.add((long) num);
        }

        // Continue processing while the smallest element is < k
        while (!q.isEmpty() && q.peek() < k) {
            if (q.size() < 2) {
                // If there's only one element left and it's < k, we can't perform any more operations
                break;
            }

            long min = q.poll(); // Get the smallest element
            long secmin = q.poll(); // Get the second smallest element
            long mediate = 2 * min + secmin; // Compute new number

            q.add(mediate); // Insert back into heap
            operations++;
        }

        return operations;
    }
}