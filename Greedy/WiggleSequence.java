/*
    Time complexity: O(N)
    Space complexity: O(1)
    
    Intuition: Greedy approach
    ----------
    Similar to finding the number of alternating max and min peaks. We do this greedily.
    When we have increasing or decreasing sub-sequence longer than 2 just ignore all middle elements 
    and use the first and the last only (we don't gain anything from the middle ones). Also ignore duplicates.
    So, at the end we'll have a "clean" wiggle sequence with the required length.
    
    If we choose any other intermediate number to be a part of the current wiggle subsequence, the maximum length of that
    wiggle subsequence will always be less than or equal to the one obtained by choosing only the consecutive max and min elements.
    
    Problem Link: https://leetcode.com/problems/wiggle-subsequence/
*/
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) 
            return nums.length;
        
        int prevDiff = 0;
        int currDiff = 0;
        int maxLen = 1; // first number is always taken
        
        for(int i = 1; i < n; i++) {
            currDiff = nums[i] - nums[i - 1];
            if ((currDiff > 0 && prevDiff <= 0) || (currDiff < 0 && prevDiff >= 0)) {
                maxLen++;
                prevDiff = currDiff;
            }
        }
        
        return maxLen;
    }
}
