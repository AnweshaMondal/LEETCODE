class Solution {
    public int maxProfit(int[] prices) {
        
    int profit = 0;
    int l = 0;
    int r = l+1;

    while(r < prices.length)
    {
      if(prices[r]>prices[l])
      {
        profit = Math.max(profit , prices[r]-prices[l]);
        r++;
      }
      else
      {
        l = r;
        r = l+1;
      }  
    }

    return profit;
    }
}