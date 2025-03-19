class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[]sol = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        int arr[]= new int[numCourses];//indegree array
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i= 0; i<numCourses; i++)
        {
            adj.add(new ArrayList<Integer>());//attaches empty lists  
        }
        //BFS->Kahn's algo
        //create adjacency list
       for(int course[]:prerequisites)
       {
         int parent = course[1];
         int child = course[0];
         adj.get(parent).add(child);
         arr[child]++;
        }
        
        //calculate in degree
        for(int i =0 ;i<numCourses; i++)
        {
            if(arr[i]==0) q.add(i);//node with indegree 0
        }

        if(q.isEmpty()) return new int[0];//vacant array

        
        while(!q.isEmpty())
        {
            int curr = q.poll();
            sol[count]=curr;
            count++;//no of completed courses
           
            for(int it:adj.get(curr))
            {
                arr[it]--;
                if(arr[it]==0)
                {
                    q.add(it);
                }
            }
        }
    
    if(count==numCourses) return sol;
    else return new int[0]; //returning empty array
    }
}