/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Intuition:
    ----------
    1. Every time we meet a 0, we decrease count by 1, and increase count by 1 when we meet 1. It's pretty easy to conclude that we
    have a contiguous subarray with equal number of 0 and 1 when count equals 0.
    2. Two points with the same y-axis value indicates the sequence between these two points has equal number of 0 and 1.
    
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
