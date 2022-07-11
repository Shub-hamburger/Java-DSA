/*
    Time complexity: O(n)
    Space complexity: O(n)
	
	Problem Link: https://leetcode.com/problems/min-cost-climbing-stairs/
*/
class Solution {
    public int climbHelper(int[] cost, int idx, int[] dp) {
        // base case
        if (idx <= 1)
            return cost[idx];
        
        if (dp[idx] != -1)
            return dp[idx];
        
        // hypothesis
        int oneStep = climbHelper(cost, idx - 1, dp);
        int twoSteps = climbHelper(cost, idx - 2, dp);
        
        // induction
        return dp[idx] = cost[idx] + Math.min(oneStep, twoSteps);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        return Math.min(climbHelper(cost, n - 1, dp), climbHelper(cost, n - 2, dp));
    }
}
