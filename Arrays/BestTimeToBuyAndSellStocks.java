/*
	Time Complexity: O(N)
	Space Complexity: O(1)
	
	Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        
        int profit = 0;
        int minPrice = prices[0];
        
        for(int i = 1; i < n; i++) {
            int currProfit = prices[i] - minPrice;
            profit = Math.max(profit, currProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return profit;
    }
}
