// Approach (Greedy)
// If the stock price goes up the next day, we should buy today and sell tomorrow
//  to capture the profit.

// We sum up all these positive price differences to get the maximum profit.


class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        for(int i = 1; i< prices.length; i++)
        {
            if(prices[i] >prices[i-1])
            {
               profit += prices[i] - prices[i-1];
            }
        }

        return profit;
    }
}