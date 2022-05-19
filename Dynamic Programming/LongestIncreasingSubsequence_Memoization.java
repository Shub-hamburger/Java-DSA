/*
    Time complexity: O(N^2)
    Space complexity: O(N^2) + O(N) -> Auxiliary stack space
    
    Problem Link: https://leetcode.com/problems/longest-increasing-subsequence/
*/
class Solution {
    public int helper(int[] nums, int ind, int prev, int[][] dp) {
        // base case
        if (ind == nums.length)
            return 0;
        
        if (dp[ind][prev + 1] != -1)
            return dp[ind][prev + 1];
        
        // hypothesis
        int notTake = helper(nums, ind + 1, prev, dp);
        int take = 0;
        if (prev == -1 || nums[ind] > nums[prev])
            take = 1 + helper(nums, ind + 1, ind, dp);
        
        // induction
        return dp[ind][prev + 1] = Math.max(notTake, take);
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return helper(nums, 0, -1, dp);
    }
}
