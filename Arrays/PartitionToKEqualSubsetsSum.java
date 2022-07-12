/*
    Time complexity: O(2^(k*n)), because if we have K trees stacked on top of each other, the new height of the tree is K * n.
    Space complexity: O(n)
    
    Problem Link: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
*/

class Solution {
    public boolean backtrack(int[] nums, int idx, int k, int subsetSum, int target, boolean[] vis) {
        // base case
        if (k == 0)
            return true;
        if (target == subsetSum) {
            return backtrack(nums, 0, k - 1, 0, target, vis);
        }
        
        // hypothesis
        for(int i = idx; i < nums.length; i++) {
            // if number is already visited or sum if out of range then skip
            if (vis[i] || subsetSum + nums[i] > target)
                continue;
            
            // Pruning
            // if the last position (i - 1) is not visited, that means it does not work for current combination, 
            // and of course this position (i) has same value, it won't work as well, skip it.
		    if (i - 1 >= 0 && nums[i] == nums[i - 1] && !vis[i - 1]) 
                continue;
            
            vis[i] = true;
            if (backtrack(nums, i + 1, k, subsetSum + nums[i], target, vis))
                return true;
                
            // backtrack
            vis[i] = false;
        }
        
        return false;
    }
    
    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        // sort the array in descending order to make the recursion hit the base case quicker 
        Arrays.sort(nums);
        reverse(nums);
        
        for(int num: nums)
            sum += num;
        
        if (sum % k != 0)
            return false;
        
        int target = sum / k;
        boolean[] vis = new boolean[n];
        
        return backtrack(nums, 0, k, 0, target, vis);
    }
}
