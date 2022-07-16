/*
    Tabulation with space optimization (2D)
    ---------------------------------------
    Time complexity : O(m * n * maxMove) 
    Space complexity : O(m * n)
    
    Problem Link: https://leetcode.com/problems/out-of-boundary-paths/
*/

class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int)1e9+7;
        int[][] prev = new int[m][n];
        
        for (int k = 1; k < maxMove + 1; ++k) {
            int[][] temp = new int[m][n];
            
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int[] d: dirs) {
                        
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n)
                            temp[i][j] = (temp[i][j] + 1) % mod;
                        else
                            temp[i][j] = (temp[i][j] + prev[x][y]) % mod;
                    }
                }
            }
            prev = temp;
        }
        return prev[startRow][startColumn];
    }
}

/*
    Tabulation (3D)
    ---------------
    Time complexity : O(m * n * maxMove) 
    Space complexity : O(m * n * maxMove)
*/

/*
class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = (int)1e9+7;
        int[][][] dp = new int[m][n][maxMove + 1];
        
        for (int k = 1; k < maxMove + 1; ++k) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int[] d: dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n)
                            dp[i][j][k] = (dp[i][j][k] + 1) % mod;
                        else
                            dp[i][j][k] = (dp[i][j][k] + dp[x][y][k - 1]) % mod;
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}
*/

/*
    Memoization
    -----------
    Time complexity : O(m * n * maxMove) 
    Space complexity : O(m * n * maxMove)
*/

/*
class Solution {
    private int mod = 1000000007;
    
    public int helper(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp) {
        // base case
        if (maxMove < 0)
            return 0;
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)
            return 1;
        
        if (dp[startRow][startColumn][maxMove] != -1)
            return dp[startRow][startColumn][maxMove];
        
        // hypothesis
        int top = helper(m, n, maxMove - 1, startRow - 1, startColumn, dp);
        int bottom = helper(m, n, maxMove - 1, startRow + 1, startColumn, dp);
        int right = helper(m, n, maxMove - 1, startRow, startColumn + 1, dp);
        int left = helper(m, n, maxMove - 1, startRow, startColumn - 1, dp);
        
        // induction
        return dp[startRow][startColumn][maxMove] = ((top + bottom) % mod + (right + left) % mod) % mod;
    }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for(int[][] mat: dp) {
            for(int[] row: mat) {
                Arrays.fill(row, -1);
            }
        }
        
        return helper(m, n, maxMove, startRow, startColumn, dp);
    }
}
*/
