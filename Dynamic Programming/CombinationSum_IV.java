/*
    Time complexity: O(m * target)
    Space complexity: O(target)
    
    where, m is the length of nums
    
    Inutition:
    ---------
    There are 4 ways to come to node with sum 4 from parent node with sum 3:
    (1 + 1 + 1) + 1 = 3 + 1 = 4.
    (1 + 2) + 1 = 3 + 1 = 4.
    (2 + 1) + 1 = 3 + 1 = 4.
    (3) + 1 = 3 + 1 = 4.
    
    There are 2 ways to come to node with sum 4 from parent node with sum 2:
    (1 + 1) + 2 = 2 + 2 = 4.
    (2) + 2 = 2 + 2 = 4.

    There is 1 way to come to node with sum 4 from parent node with sum 1:
    (1) + 3 = 1 + 3 = 4.
    
    So, if we have already stored in cnt[] array the number of nodes with sum 1 in cnt[1] = 1, the number of nodes with sum 2 in
    cnt[2] = 2, the number of nodes with sum 3 in cnt[3] = 4, then we can calculate the number of nodes with sum 4 by reusing 
    cnt[1], cnt[2], cnt[3]:

    cnt[4] = cnt[1] + cnt[2] + cnt[3] = 1 + 2 + 4 = 7
    
    Problem Link: https://leetcode.com/problems/combination-sum-iv/
*/
class Solution {
    public int combinationHelper(int[] nums, int idx, int target, int[] dp) {
        // base case
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else if (idx == nums.length && target != 0) {
            return 0;
        }
        
        if (dp[target] != -1)
            return dp[target];
        
        // hypothesis
        int includingCurrent = combinationHelper(nums, 0, target - nums[idx], dp);
        int excludingCurrent = combinationHelper(nums, idx + 1, target, dp);
        
        // induction
        return dp[target] = includingCurrent + excludingCurrent;
    }
    
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        
        return combinationHelper(nums, 0, target, dp);
    }
}
