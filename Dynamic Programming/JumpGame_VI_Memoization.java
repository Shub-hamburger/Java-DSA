/*
    Memoization - Gives TLE on Leetcode
    -----------
    Time complexity: O(k * n)
    For each index, we are trying out k jumps and storing the results to avoid future recomputations. Overall, the time complexity required is
    k+k+k...N times = O(kN)
    
    Time complexity for recursion will be: O(k ^ n)
    
    Space complexity: O(N)
*/

class Solution {
    public int helper(int[] nums, int k, int idx, int[] dp) {
        // base case
        if (idx >= nums.length - 1)
            return nums[nums.length - 1];
        
        if (dp[idx] != Integer.MIN_VALUE)
            return dp[idx];
        
        int score = Integer.MIN_VALUE;
        for(int j = 1; j <= k; j++) {
            score = Math.max(score, nums[idx] + helper(nums, k, idx + j, dp));
        }
        
        return dp[idx] = score;
    }
    
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        
        return helper(nums, k, 0, dp);
    }
}
