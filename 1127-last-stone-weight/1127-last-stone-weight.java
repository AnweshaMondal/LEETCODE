//a PriorityQueue in Java behaves like a heap (tree-based structure) but is stored
// internally as an array for efficiency. It maintains the heap property,
// not a fully sorted order.

// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         //create a max heap 
//         PriorityQueue<Integer> maxHeap = new  PriorityQueue<>(Collections.reverseOrder());

//         //for each loop add all elements to the heap
//         for(int element: stones){
//             maxHeap.add(element);
//         }

//         //while no of ele in heap>1 remove 2 each time
//         while(maxHeap.size()>1){
//             int first = maxHeap.poll();
//             int second = maxHeap.poll();

//             //if not of equal size
//             if(first>second){
//                 maxHeap.add(first-second);//automatically adjusts heap property\U0001f642
//             }
//         }
//         if(!maxHeap.isEmpty()){
//         return maxHeap.poll();
//         }
//         else{
//             return 0;
//         }
//     }
// }

class Solution {
    public int lastStoneWeight(int[] stones) {

     int index = stones.length-1;
        
        while(index>0){

            Arrays.sort(stones);
            int f = stones[index];
            int s = stones[index-1];

            if(f==s){
                index-=2;
            }
            else{
                index--;
                stones[index] = f-s;
            }
        }

        if(index==0){
            return stones[0];
        }
        else{
            return 0;
        }

    }
}