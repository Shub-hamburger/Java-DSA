/*
    Time complexity: O(N * target)
    Space complexity: O(N * target) + O(N) -> Auxiliary stack space
    
    Here, N is len(nums) and target = sum(nums) / 2;
    
    Problem Link: https://leetcode.com/problems/partition-equal-subset-sum/
*/
class Solution {
    public boolean helper(int[] nums, int target, int ind, int[][] dp) {
        // base case
        if (target == 0)
            return true;
        if (ind == 0) {
            return nums[ind] == target;
        }
        
        if (dp[ind][target] != -1) {
            return dp[ind][target] == 0 ? false : true;
        }
        
        // hypothesis
        boolean notPick = helper(nums, target, ind - 1, dp);
        boolean pick = false;
        if (nums[ind] <= target)
            pick = helper(nums, target - nums[ind], ind - 1, dp);
        
        // induction
        dp[ind][target] = notPick || pick ? 1 : 0;
        return notPick || pick;
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; i++)
            sum += nums[i];
        
        if (sum % 2 != 0)
            return false;
        
        int target = sum / 2;
        
        int[][] dp = new int[n][target + 1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return helper(nums, target, n - 1, dp);
    }
}
