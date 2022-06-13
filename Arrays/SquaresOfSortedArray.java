/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/squares-of-a-sorted-array/
*/
class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] res = new int[nums.length];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                res[i] = nums[start] * nums[start];
                start++;
            } else {
                res[i] = nums[end] * nums[end];
                end--;
            }
        }
        
        return res;
    }
}
