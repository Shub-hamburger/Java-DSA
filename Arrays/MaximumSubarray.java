/*
	Time Complexity: O(N)
	Space Complexity: O(1)
	
	Problem Link: https://leetcode.com/problems/maximum-subarray/
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = Integer.MIN_VALUE;
         
        for (int i = 0; i < nums.length; i++) {
            currSum = nums[i] + Math.max(currSum, 0);
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}
