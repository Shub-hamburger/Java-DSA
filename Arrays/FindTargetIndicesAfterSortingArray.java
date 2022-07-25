/*
    Time complexity: O(n)
    Space complexity: O(1) -> excluding space taken for output.
    
    Inutition:
    ----------
    For understanding the logic let take and example - [1,2,5,2,3,3] 
    Now, for target = 3, 
        1. We count occurrence of 3 and occurrence of numbers smaller than 3. We'll 2 & 3 respectively. 
        2. This means in the sorted array 3 starts form the index 3, as there are 3 numbers smaller than 3
        3. And 3 ends at the index 4 as there are only 2 occurrences of 3. Thus, the output is [3, 4]
		
	Problem Link: https://leetcode.com/problems/find-target-indices-after-sorting-array/
*/
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;
        int lessThanTarget = 0;
        List<Integer> res = new ArrayList<>();
        
        for (int n : nums) {
            if (n == target) 
                count++;
            if (n < target) 
                lessThanTarget++;
        }
        
        
        for (int i = 0; i < count; i++) {
            res.add(lessThanTarget);
            lessThanTarget++;
        }
        
        return res;
    }
}
