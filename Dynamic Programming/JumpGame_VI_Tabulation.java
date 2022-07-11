/*
    Tabulation
    ----------
    Time complexity: O(k * n)
    For each index, we are trying out k jumps and storing the results to avoid future recomputations. Overall, the time complexity required is
    k+k+k...N times = O(kN)
        
    Space complexity: O(N)
*/

class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        
        // initalization
        dp[0] = nums[0];
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= k && i - j >= 0; j++) {
                dp[i] = Math.max(dp[i], nums[i] + dp[i - j]);
            }
        }
        
        return dp[n - 1];
    }
}
