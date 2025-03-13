class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n = nums1.length;//smaller
        int m = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();//key, value
        for(int i = 0; i<nums2.length; i++)
        {
            map.put(nums2[i],i);
        }

        int[] ans = new int[n];
        for(int i = 0; i<n; i++)
        {   
            int ele= nums1[i];
            int j = map.get(ele);

            for(int k = j; k<m; k++)
            {
                if(nums2[k]>ele)
                {
                    ans[i] = nums2[k];
                    break;
                }
                else
                {
                    //no greater element on thr RHS
                    ans[i] = -1;
                } 
            }

        }
    
    return ans;
    }
}