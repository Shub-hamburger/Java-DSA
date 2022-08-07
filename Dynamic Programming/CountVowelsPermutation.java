/*
    Tabulation
    ----------
    Time complexity: O(N)
    Space complexity: O(N)
*/

class Solution {
    public int countVowelPermutation(int n) {
        int MOD = (int) (1e9 + 7);
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        /*
            0: a
            1: e
            2: i
            3: o
            4: u
         */
        for (int i = 1; i < n; i++) {
            dp[i+1][0] = (dp[i][4] + dp[i][1] + dp[i][2]) % MOD;
            dp[i+1][1] = (dp[i][0] + dp[i][2]) % MOD;
            dp[i+1][2] = (dp[i][3] + dp[i][1]) % MOD;
            dp[i+1][3] = (dp[i][2]) % MOD;
            dp[i+1][4] = (dp[i][2] + dp[i][3]) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < 5; i++)
            ans = (ans + dp[n][i]) % MOD;
        return (int) ans;
    }
}

/*
    Memoization
    -----------
    Time complexity: O(N)
    Space complexity: O(N)
*/

/*
class Solution {
    private int mod = (int) (1e9 + 7);
    
    public long countHelper(int idx, int n, char ch, long[][] dp, HashMap<Character, Integer> map) {
        // base case
        if (idx == n)
            return 1;
        
        if (dp[idx][map.get(ch)] != -1)
            return dp[idx][map.get(ch)] % mod;
        
        // hypothesis
        long count = 0;
        
        if (ch == 'a') {
            count += countHelper(idx + 1, n, 'e', dp, map);
        }
        if (ch == 'e') {
            count += countHelper(idx + 1, n, 'a', dp, map);
            count += countHelper(idx + 1, n, 'i', dp, map);
        }
        if (ch == 'i') {
            count += countHelper(idx + 1, n, 'a', dp, map);
            count += countHelper(idx + 1, n, 'e', dp, map);
            count += countHelper(idx + 1, n, 'o', dp, map);
            count += countHelper(idx + 1, n, 'u', dp, map);
        }
        if (ch == 'o') {
            count += countHelper(idx + 1, n, 'i', dp, map);
            count += countHelper(idx + 1, n, 'u', dp, map);
        }
        if (ch == 'u') {
            count += countHelper(idx + 1, n, 'a', dp, map);
        }
        
        return dp[idx][map.get(ch)] = count % mod;
    }
    
    public int countVowelPermutation(int n) {
        long count = 0;
        char[] charArray = new char[] {'a', 'e', 'i', 'o', 'u'};
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], i);
        }
        
        long[][] dp = new long[n + 1][5];
        for(long[] row: dp)
            Arrays.fill(row, -1);
        
        for(char ch: charArray)
            count = (count + countHelper(1, n, ch, dp, map)) % mod;
        
        return (int)count;
    }
}
*/
