/*
    Time Complexity: O(n ^ 2)
    Space Complexity: O(N)
    
    Intuition:
    ---------
    1. sort the array and use HashMap to record each Integer, and the number of trees with that Integer as root
    2. each integer A[i] will always have one tree with only itself
    3. if A[i] has divisor (a) in the map, and if A[i]/a also in the map
        then a can be the root of its left subtree, and A[i]/a can be the root of its right subtree;
        the number of such tree is map.get(a) * map.get(A[i]/a)
    4. sum over the map
    
    Problem Link: https://leetcode.com/problems/binary-trees-with-factors/submissions/
*/
class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x: dp) ans += x;
        return (int) (ans % MOD);
    }
}
