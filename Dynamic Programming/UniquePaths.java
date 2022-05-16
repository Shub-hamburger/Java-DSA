/*
    Time complexity: O(mn)
    Space complexity: O(mn) + O((m -1) + (n - 1)) -> Auxiliary Stack Space; (m - 1) + (n - 1) is the path length
	
	Problem Link: https://leetcode.com/problems/unique-paths/
*/
class Solution {
    public int helper(int m, int n, int[][] dp) {
        // base case
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;
        
        if (dp[m][n] != -1)
            return dp[m][n];
        
        // hypothesis
        int moveDown = helper(m - 1, n, dp);
        int moveRight = helper(m, n - 1, dp);
        
        // induction
        return dp[m][n] = moveDown + moveRight;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return helper(m - 1, n - 1, dp);
    }
}
