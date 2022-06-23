/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/contiguous-array/
*/
class Solution {
    public int findMaxLength(int[] nums) {        
        int maxLen = 0;
        int count = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
                
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if (num == 0)
                count--;
            else
                count++;
            
            if (map.containsKey(count))
                maxLen = Math.max(maxLen, i - map.get(count));
            else
                map.put(count, i);
            
        }
        
        return maxLen;
    }
}
