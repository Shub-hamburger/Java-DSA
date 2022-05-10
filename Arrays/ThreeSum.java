/*
    Time complexity: O(N^2)
    Space complexity: O(1)
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < n - 2; i++) {
            int first = nums[i];
            int target = -first;
            
            int start = i + 1;
            int end = n - 1;
            
            while (start < end) {
                int second = nums[start];
                int third = nums[end];
                int currSum = second + third;
                
                if (currSum > target)
                    end--;
                else if (currSum < target)
                    start++;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(first);
                    temp.add(second);
                    temp.add(third);
                    
                    ans.add(temp);
                    
                    // handling duplicates for second
                    while (start < end && nums[start] == second)
                        start++;
                    
                    // handling duplicates of third
                    while (start < end && nums[end] == third)
                        end--;
                }
            }
            
            // handling duplicates of first
            while (i + 1 < n && nums[i + 1] == first)
                i++;
        }
        
        return ans;
    }
}
