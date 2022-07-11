/*
    DP + Deque
    ----------
    Time complexity: O(N)
    Space complexity: O(N)
    
    Inuition:
    ---------
    We can maintain a simple double-side queue in a sorted order to reduce the previous lookup using priority queue from O(logk) down to O(1).
    Here we will store the indices instead of dp[i] in the queue.
    
    We will pop i-k-1th index from queue since it will be useless to us. Along with that, we will also pop those indices which will never have 
    any chance of being chosen in the future. So for eg., if the score for current index - dp[i] is greater than some indices stored in the queue, 
    it will always be optimal to choose dp[i] instead of those other indices. So, we will just pop those indices from queue since they won't ever be used.
    
    Problem Link: https://leetcode.com/problems/jump-game-vi/
*/
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);
        dp[0] = nums[0];
        
        for(int i = 1; i < n; i++) {
            if(dq.peekFirst() < i-k) {
                dq.pollFirst();
            }

            dp[i] = nums[i] + dp[dq.peekFirst()];

            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        return dp[n-1];
    }
}
