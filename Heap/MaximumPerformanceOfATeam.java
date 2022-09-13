/*
    Time complexity: O(NlogN)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/maximum-performance-of-a-team/
*/
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] mat = new int[n][2];
        for(int i = 0; i < n; i++) {
            mat[i] = new int[] {efficiency[i], speed[i]};
        }
        
        Arrays.sort(mat, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long ans = 0, sum = 0;
        
        for(int[] arr: mat) {
            pq.add(arr[1]);
            sum += arr[1];
            if (pq.size() > k)
                sum -= pq.poll();
            ans = Math.max(ans, sum * arr[0]);
        }
        
        return (int) (ans % (long)(1e9 + 7));
    }
}
