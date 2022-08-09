/*
    Time Complexity: O(n ^ 2)
    Space Complexity: O(N)
*/
class Solution {
    private int mod = (int) 1e7 + 9;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            idxMap.put(arr[i], i);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (idxMap.containsKey(right))
                        dp[i] = (dp[i] + dp[j] * dp[idxMap.get(right)]) % mod;
                }
            }
        }
        
        long ans = 0;
        for(long num: dp)
            ans += num;
        
        return (int) (ans % mod);
    }
}
