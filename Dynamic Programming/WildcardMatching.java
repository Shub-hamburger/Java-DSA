/*
    Time complexity: O(M * N)
    Space complexity: O(M * N)
    
    where M is the length of patter (p) and s is the length of the string (s)
    
    Intuition:
    ----------
    For every index of string s, we have different options to match that index with pattern p. 
    Now, we have the following options:

        1. Tthe characters match.
        2. Or, if there is a '?', we can explicitly match a single character.
        3. For a '*', we try out all possibilities
        
    Base cases:
    -----------
    1. if (m == 0 && n == 0) return true;
    2. if (m > 0 && n == 0) return false;
    3. if (m == 0 && n > 0) {
          for(int i = 0; i < n; i++) {
              if (p.charAt(i) != '*')
                  return false;
          }
          return true;
       }
	   
	Problem Link: https://leetcode.com/problems/wildcard-matching/
*/

class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Initialization
        for(int i = 1; i <= m; i++) {
            boolean flag = true;
            /*
                When n == 0 and m > 0
                We check if the characters left in pattern (p) are all '*' or not. 
                If yes, then we matched and will return true. Otherwise, we didn't match
            */
            for(int j = 1; j <= i; j++) {
                if (p.charAt(j - 1) != '*') {
                    flag = false;
                    break;
                } 
            }
            dp[i][0] = flag;
        }
        
        // if m == 0 && n == 0 then we've a match and thus return true
        dp[0][0] = true;
        
        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else 
                    dp[i][j] = false;
            }
        }
        
        return dp[m][n];
    }
}
