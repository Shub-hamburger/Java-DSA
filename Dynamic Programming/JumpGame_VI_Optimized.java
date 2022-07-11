/*
    Using DP + Priority Queue
    -------------------------
    Time complexity: O(n * logk); logk is taken by priority queue
    Space complexity: O(n) + O(k) ~ O(n)
    
    Intuition:
    ----------
    We need to get the maximum score within a given window (k steps) preceeding current node(inclusive) and it would give us the maximum score for the current node. 
    At a given node we only need the nearest k nodes data to process. For this we use a priority queue to fetch maximum score in O(1).
    
    Problem Link: https://leetcode.com/problems/jump-game-vi/
*/
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        // initalization
        dp[0] = nums[0];
        pq.add(new int[] {0, dp[0]});
        
        for(int i = 1; i < n; i++) {
            while (pq.peek()[0] < i - k)
                pq.poll();
                
            dp[i] = pq.peek()[1] + nums[i];
            pq.add(new int[] {i, dp[i]});
        }
        
        return dp[n - 1];
    }
}
