//Dyanamic Programming -> nested loop
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();

        for(int row = n-2; row>=0 ; row--){
             for(int col = 0; col<triangle.get(row).size() ; col++){

                int curr = triangle.get(row).get(col);//i th col of n th row
                int left = triangle.get(row+1).get(col);//i th col of n+1 th row
                int right = triangle.get(row+1).get(col+1);//i+1 th col of n+1 th row

                triangle.get(row).set(col,Math.min(left,right)+curr);//to put an element in a java ArrayList\U0001f642->arrlist.set()  
            }
        }
       return triangle.get(0).get(0);
    }
}