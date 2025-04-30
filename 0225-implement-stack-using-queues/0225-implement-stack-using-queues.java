class MyStack {
  
   Queue<Integer> q;

    public MyStack() {
        //Declare a queue
         q = new LinkedList<Integer>();
    }
    //push = O(1)
    public void push(int x) {
        q.add(x);
    }
    
    //pop in O(N) time
    public int pop() {
        int size = q.size();
         int pop = -999;
        for(int i = 0; i<size-1; i++){
             pop = q.poll();
            //Move elements to the back of the queue except the last one
            q.add(pop);
            }
            //remove the last element
            return q.poll();
        }
    
    //O(N) TC
    public int top() {
        int size = q.size();
        int pop = -999;
        for(int i = 0; i<size; i++){
             pop = q.poll();
            //add it back
            q.add(pop);
        }
        //when the loop ends, pop holds val of last entered element
        return pop;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */