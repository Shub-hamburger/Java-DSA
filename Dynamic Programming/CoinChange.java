/*
    Time complexity: O(N * Amount)
    Space complexity: O(N * Amount) + O(N) -> Auxiliary Stack Space
    
    Here, N is the #coins
    
    Problem Link: https://leetcode.com/problems/coin-change/
*/
class Solution {
    public int helper(int[] coins, int amount, int n, int[][] dp) {
        // base case
        if (n == 0) {
            if (amount % coins[n] == 0)
                return amount / coins[n];
            else
                return (int)Math.pow(10, 9);
        }
        
        if (dp[n][amount] != -1)
            return dp[n][amount];
        
        // hypothesis
        int notPick = 0 + helper(coins, amount, n - 1, dp);
        
        int pick = (int)Math.pow(10, 9);
        if (coins[n] <= amount) 
            pick = 1 + helper(coins, amount - coins[n], n, dp);
        
        // induction
        return dp[n][amount] = Math.min(pick, notPick);
    }
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        int ans = helper(coins, amount, coins.length - 1, dp);
        if (ans >= (int)Math.pow(10,9)) 
            return -1;
        return ans;
    }
}
