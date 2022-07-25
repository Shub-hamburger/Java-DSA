/*
    Time complexity: O(logN)
    Space complexity: O(1)
    
    Intuition:
    ----------
    1. Since the array is sorted we should definitely think about binary search.
    2. For finding the starting position, even if find the target, we keep searching in the left side of the search
       space as we have duplicates and we can expect an occurrence of target before the current ans too.
    3. For finding the ending position, even if find the target, we keep searching in the right side of the search
       space as we have duplicates and we can expect an occurrence of target after the current ans too.
*/
class Solution {
    public int findPosition(int[] nums, int target, boolean isFindingFirst) {
        int left = 0;
        int ans = -1;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else {
                ans = mid;
                // ans found but keep on searching as we may find a smaller idx on the left side of the search space.
                if (isFindingFirst)
                    right = mid - 1;
                
                // ans found but keep on searching as we may find a larger idx on the right side of the search space.
                else
                    left = mid + 1;
            }
        }
        
        return ans;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[2];
        
        // Find the starting position
        pos[0] = findPosition(nums, target, true);
        // Find the ending position
        pos[1] = findPosition(nums, target, false);
        
        return pos;
    }
}
