/*
    Time complexity: O(N ^ 2)
    Space complexity: O(1)
    
    Intuition
    ---------
    If the sum is less than target, it means we have to add a larger element so next element move to the
    next. If the sum is greater, it means we have to add a smaller element so last element move to the
    second last element.
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        
        int closestDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            int first = nums[i];
            
            int start = i + 1;
            int end = n - 1;
            
            while (start < end) {
                int second = nums[start];
                int third = nums[end];

                int currSum = first + second + third;
                int targetDiff = target - currSum;
                    
                if (targetDiff == 0)
                    return target - targetDiff;
                
                if (Math.abs(targetDiff) < Math.abs(closestDiff)) {
                    closestDiff = targetDiff;
                }
                    
                if (targetDiff > 0)
                    start++;
                else if (targetDiff < 0)
                    end--;
            }
        }
        
        return target - closestDiff;
    }
}
