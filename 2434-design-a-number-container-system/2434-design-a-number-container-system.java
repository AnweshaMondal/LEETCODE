// class NumberContainers {
    
//     List<Integer> numList = new ArrayList<>();  

//     public NumberContainers() 
//     {  
//         // NumberContainers numSystem = new NumberContainers();
//     }
    
//     public void change(int index, int number) 
//     {
//         // To replace an element in Java ArrayList, set() method of java.util
//         if(index<numList.size())
//         {
//          numList.set(index,number); //May give indexOutOfBounds if the list.size()<index
//         }
//         else
//         {
//             int[] arr = new int[index+1];
//             arr[index] = number;
//             //fill the array with the existing list's elements
//              for(int i = 0; i<numList.size(); i++)
//              {
//                 arr[i] = numList.get(i);
//              }

//             //put all elements in the numList
//             numList.clear();//resets the ArrayList
//             for(int i = 0; i<arr.length; i++)
//             {
//                 numList.add(arr[i]);
//             }
//         }
       
//     }
    
//     public int find(int number) 
//     {
//       //This method returns the index of the first occurrence of the specified element in
//       // this list, or -1 if this list does not contain the element.  
//       return numList.indexOf(number);
//     }
// }-->Memory Limit Exceeded


/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

//  class NumberContainers {

//     public NumberContainers() 
//     {
//      Map<Integer,> 
//     }

//      public void change(int index, int number) 
//     {
//     }

//       public int find(int number) 
//     {
//     }
//  }


//  Optimized Code Using HashMap + TreeSet
class NumberContainers {
    private Map<Integer, Integer> indexToNumber; // Maps index → number
    private Map<Integer, TreeSet<Integer>> numberToIndices; // Maps number → sorted indices

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (numberToIndices.containsKey(oldNumber)) {
                numberToIndices.get(oldNumber).remove(index);
                if (numberToIndices.get(oldNumber).isEmpty()) {
                    numberToIndices.remove(oldNumber);
                }
            }
        }

        indexToNumber.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        if (!numberToIndices.containsKey(number) || numberToIndices.get(number).isEmpty()) {
            return -1;
        }
        return numberToIndices.get(number).first();
    }
}