class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        HashSet <Integer> set = new HashSet<>();
        
        //Fill the HashSet
         // Add all elements of nums to the HashSet
        for (int num : nums) {
            set.add(num);
        }

        for(int i = 1; i<=n ; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }
}