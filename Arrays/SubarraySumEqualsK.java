/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Intuition
    ---------
    The value of currsum exceeds the desired sum by currsum – sum. If this value is removed from currsum then the
    desired sum can be obtained. From the map, find the number of subarrays previously found having sum equal to
    currsum-sum. 
    
    Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int subSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int num: nums) {
            subSum += num;
            int diff = subSum - k;
            
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }
            
            if (map.containsKey(subSum))
                map.put(subSum, map.get(subSum) + 1);
            else
                map.put(subSum, 1);
        }
        
        return count;
    }
}
