/*
    Time complexity: O(N)
    Space complexity: O(1)
	
	Problem Link: https://leetcode.com/problems/jump-game/submissions/
*/
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++) {
            if (i > maxReach)
                return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
