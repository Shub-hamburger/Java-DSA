/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/two-sum/submissions/
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int idx1 = -1;
        int idx2 = -1;
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            idx1 = i;
            
            if (map.containsKey(target - curr)) {
                idx2 = map.get(target - curr);
                break;
            }
            map.put(curr, i);
        }
        
        return new int[]{idx1, idx2};
    }
}
