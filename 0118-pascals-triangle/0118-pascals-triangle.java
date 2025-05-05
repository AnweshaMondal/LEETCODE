class Solution {
    public List<List<Integer>> generate(int numRows) {

        
        if(numRows == 1) return new ArrayList<>(Arrays.asList(Arrays.asList(1)));
        if(numRows == 2) return new ArrayList<>(Arrays.asList(
                                                              Arrays.asList(1),
                                                              Arrays.asList(1,1)));

        else
        {
           List<List<Integer>> mainList = new ArrayList<>(Arrays.asList(Arrays.asList(1),
                                                          Arrays.asList(1,1)));;

          for(int i = 2; i<numRows; i++)
          {
            int size = mainList.size();
            List<Integer> row = mainList.get(size -1);
            List<Integer> newrow = new ArrayList<Integer>();
            newrow.add(1);
            int l = 0;
            int r = l+1;

            while(r < row.size())
            {
                newrow.add(row.get(l)+row.get(r));
                l++;
                r++;
            }
            newrow.add(1);
            mainList.add(newrow);
          }
          return mainList;
        }

      
    }
}