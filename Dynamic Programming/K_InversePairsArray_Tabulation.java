/*
    Optimised Tabulation (DP + Sliding window)
    ------------------------------------------
    Time complexity : O(n * k)     
    Space complexity : O(n * k)
    
    Maths behind optimzation:
    -------------------------
    The recurrence equation goes like this :

    T(n,k) = T(n-1,k) + T(n-1,k-1) + ........ + T(n-1,k-n+1) ---> 1

    for k+1 it goes like :

    T(n,k+1) = T(n-1,k+1) + T(n-1,k) +.......... + T(n-1,k+1-n+1) ----> 2

    now when you do 2 - 1 you get :
    T(n,k+1) - T(n,k) = T(n-1,k+1) - T(n-1,k-n+1)
    or T(n,k+1) = T(n,k) + T(n-1,k+1) - T(n-1,k-n+1)

    replace k+1 by k and our final equation becomes :
    T(n,k) = T(n,k-1) + T(n-1,k) - T(n-1,k-n)
    
    Thus, we can use a sliding window technique to calculate dp[N][K] in O(1) by keeping the cumulative
    sum, reducing the overall time complexity to O(n * k) as we won't need to traverse the the previous
    row.
    
    At the end, while returning the result, we need to return dp[n][k] - dp[n][k-1] to obtain the required
    result from the cumulative sums.
    
    Problem Link: https://leetcode.com/problems/k-inverse-pairs-array/
*/

class Solution {
    private int mod = 1000000007;
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = (dp[i - 1][j] + (j > 0 ? dp[i][j - 1] : 0)) % mod;
                    if (j >= i)
                        dp[i][j] = (mod + dp[i][j] - dp[i - 1][j - i]) % mod;
                }
            }
        }
        return (dp[n][k] + mod - (k > 0 ? dp[n][k - 1] : 0)) % mod;
    }
}

/*
    Tabulation - Gives TLE (80 / 80 test cases passed, but took too long)
    ----------
    Time complexity : O(n * k * min(n, k)) 
    The dp table of size n * k is filled once. Filling each entry takes O(min(n,k)) time.
    
    Space complexity : O(n * k)
    
    Intuition:
    ----------
    If we know the number of inverse pairs (say x) in any arbitrary array bb with some nn, we can add a new element n+1 to
    this array 'b' at a position 'p' steps from the right, such that x + p = k to generate an array with a total of k
    inverse pairs.
    
    We can obtain the recursive formula for finding the number of arrangements with exactly 'k' inverse pairs as follows.
    
    Let's say count(i,j) represents the number of arrangements with 'i' elements and exactly 'j' inverse pairs.
    
        1. If n=0, no inverse pairs exist. Thus, count(0,k) = 0.
        2. If k=0, only one arrangement is possible, which is all numbers sorted in ascending order. Thus, count(n, 0) = 1.
        3. Otherwise, count(n,k) = ∑count(n−1,k−i) where i = 0 to min(k, n - 1).
*/

/*
class Solution {
    private int mod = 1000000007;
    public int kInversePairs(int n, int k) {        
        int[][] dp = new int[n + 1][k + 1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    for(int m = 0; m <= Math.min(i - 1, j); m++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - m]) % mod;
                    }
                }
            }
        }
        
        return dp[n][k];
    }
}
*/
