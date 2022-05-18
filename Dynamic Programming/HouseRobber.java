/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/house-robber/
*/
class Solution {
    public int helper(int[] nums, int ind, int[] dp) {
        // base case
        if (ind < 0)
            return 0;
        
        if (dp[ind] != -1)
            return dp[ind];
        
        // hypothesis
        int notPick = helper(nums, ind - 1, dp);
        int pick = nums[ind] + helper(nums, ind - 2, dp);
        
        // induction
        return dp[ind] = Math.max(notPick, pick);
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return helper(nums, n - 1, dp);
    }
}
