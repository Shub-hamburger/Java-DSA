/*
    Time complexity: O(m * n ^ 2 * t)
    Space complexity: O(m * n * t)
    
    where, m is the no. of houses, n is the no. of colors and t is the target neighborhoods.
    
    Intuition behind time complexity:
    ---------------------------------
    Magic Formula: DP Time Complexity = Number of Function Calls x Work Done per Function Call

    1. Number of Function Calls
    Well right off the bat, we know we are using memoization to avoid any repeated work. So the number of function calls will be the
    same as the number of unique states. 
    Here our state values are m = number of houses, t = number or neighborhoods, and n = different colors.

    We have m * t * n possible unique combinations so m * t * n function calls

    2. Work Done per Function Call
    We treat recursive DP calls as constant time operations. So the real work we are doing is picking the color of the house thus,
    O(different colors). Remember, we defined n = different colors so the work done on each function call is looping through n colors
    for O(n).

    3. Get Our Answer
    DP Time Complexity = Number of Function Calls x Work Done per Function Call = (m * t * n) * (n) = O(m * t * n * n)
    
    Intuition behind solution:
    --------------------------
    We try every possible color for unpainted houses and find the cost. After traversing all of the houses, if the number of
    neighborhoods equals target, then we can compare the cost with the minimum cost we have achieved so far and update it
    accordingly.
*/
class Solution {
    private int MAX = (int)1e8;
    public int minCostHelper(int[] houses, int[][] cost, int m, int n, 
                             int idx, int prevColor, int target, int[][][] dp) {
        // base case
        if (idx == m || target < 0) 
            return target == 0 ? 0 : MAX;
        
        if (dp[idx][prevColor][target] != -1)
            return dp[idx][prevColor][target];
        
        // if house is already painted - only check if it forms a new neighborhood
        if (houses[idx] != 0) {
            int currColor = houses[idx];
            boolean isSameColor = currColor != prevColor;
            return dp[idx][prevColor][target] = minCostHelper(houses, cost, m, n, idx + 1, currColor, target - (isSameColor ? 1 : 0), dp);
        }
        
        // try painting for every color
        int res = MAX;
        for(int color = 1; color <= n; color++) {
            boolean isSameColor = color != prevColor;
            int val = minCostHelper(houses, cost, m ,n, idx + 1, color, target - (isSameColor ? 1 : 0), dp);
            res = Math.min(res, val + cost[idx][color - 1]);
        }
        
        return dp[idx][prevColor][target] = res;
    }
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++)
                Arrays.fill(dp[i][j], -1);
        }
        
        int ans = minCostHelper(houses, cost, m, n, 0, 0, target, dp);
        return ans >= MAX ? -1 : ans;
    }
}
