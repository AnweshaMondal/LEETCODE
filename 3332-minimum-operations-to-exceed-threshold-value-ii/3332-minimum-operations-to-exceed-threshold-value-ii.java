class Solution {
    public int minOperations(int[] nums, int k) {
        
      PriorityQueue<Long> q = new PriorityQueue<Long>();
      int operations = 0;

      for(int i = 0; i<nums.length; i++)
      {
        q.add((long)nums[i]); //Insert All elements inside the queue
      }
     
     while(q.size()>=2 && q.peek()< k) //untill the least element is less than K , loop through
     {
       long min = q.poll();
       long secmin = q.poll();
       long mediate = 2*min +secmin;
       q.add(mediate);
       operations++;
     }
      return operations;
    }
}